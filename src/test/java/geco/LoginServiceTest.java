package geco;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void loginExists() {
        LoginService ls = new LoginService(new String[]{"exists"});
        String loginExist = "exists";
        String loginDoesNotExist = "doesn't exist";
        assertTrue("The string exists", ls.loginExists(loginExist));
        assertFalse("The string doesn't exist", ls.loginExists(loginDoesNotExist));
    }

    @Test
    public void addLogin() {
        LoginService ls = new LoginService(new String[]{});
        assertEquals("There should be no item yet", 0, ls.findAllLogins().size());
        ls.addLogin("Login");
        assertNotEquals("There shouldn't be no item", 0, ls.findAllLogins().size());
        assertEquals("There should be one item", 1, ls.findAllLogins().size());
        assertEquals("The login should be 'Login'", ls.findAllLogins().get(0), new String("Login"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        LoginService ls = new LoginService(new String[]{"test1","test2"});
        assertTrue("No login is equal to 'noTest'", ls.findAllLoginsStartingWith("noTest").size() == 0);
        assertTrue("There are 2 logins with 'test' string in them", ls.findAllLoginsStartingWith("test").size() == 2);

    }

    @Test
    public void findAllLogins() {
        LoginService ls = new LoginService(new String[]{"test"});
        assertEquals("There should be only one item", 1, ls.findAllLogins().size());
        ls.addLogin("Login");
        assertEquals("There should be two items", 2, ls.findAllLogins().size());
        assertEquals("The login should be 'test'", ls.findAllLogins().get(0), new String("test"));
        assertEquals("The login should be 'Login'", ls.findAllLogins().get(1), new String("Login"));
    }
}