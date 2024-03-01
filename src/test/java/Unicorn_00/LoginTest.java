package Unicorn_00;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private Authentication authentication;
    private Login login;

    @BeforeEach
    public void setUp() {
        authentication = new Authentication(); // Create a new Authentication instance for each test
        login = new Login(authentication); // Create a new Login instance for each test
    }
    @Test
    void testLoginUser() {

        //LogIn already registered user
        assertTrue(login.loginUser("John", "password"));
        assertTrue(login.isLoggedIn());
        //User logged out
        login.logout();
        assertFalse(login.isLoggedIn());
        //User with no record tries to login
        assertFalse(login.loginUser("Bon", "88Password"));
        assertFalse(login.isLoggedIn());
        //System.out.println("....");
        //User tries to login again even though they are already logged in
        assertTrue(login.loginUser("John", "password"));
        assertTrue(login.isLoggedIn());
        assertFalse(login.loginUser("John", "password"));
    }
}



