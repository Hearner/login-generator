package geco;

import java.util.Random;

public class PasswordGeneration {

    /**
     * Generate a 8 caracter long random numbers password.
     * @return the random password
     */
    private String getRandomPassword() {
        String password = new String();
        Random r = new Random();
        char c;
        for (int i = 0; i < 8; i++) {
            c = (char) (r.nextInt(26) + 'a');
            password += c;
        }

        return password;
    }
}
