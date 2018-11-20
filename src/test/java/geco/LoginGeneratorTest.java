package geco;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    @Test
    public void generateLoginForNomAndPrenom() {
        LoginService loginService = new LoginService(new String[] {"JROL",
                "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        // Generate the login Paul Durant
        assertTrue("Paul Durant should return PDUR",
                loginGenerator.generateLoginForNomAndPrenom("Durant", "Paul").equals("PDUR"));
        // The new login should be added into the login list
        assertTrue("The new PDUR should be added into the login list",
                loginGenerator.getloginService().findAllLoginsStartingWith("PDUR").size() > 0);
    }

    @Test
    public void generateLoginFromNomAndPrenomAlreadyExist() {
        LoginService loginService = new LoginService(new String[] {"JROL",
                "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);

        // 2 JRAL already exist
        assertFalse("John Ralling should not return JRAL",
                loginGenerator.generateLoginForNomAndPrenom("Ralling", "John").equals("JRAL"));
        assertTrue("The new JRAL2 should be added into the login list",
                loginGenerator.getloginService().findAllLoginsStartingWith("JRAL2").size() > 0);
    }
}