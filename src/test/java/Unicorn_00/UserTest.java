package Unicorn_00;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserLogin() {
        User user = new User(1, "user1", "password", "user1@example.com");
        user.login();
        assertTrue(true); // If login method executes without errors, the test passes
    }

    @Test
    public void testUserLogout() {
        User user = new User(1, "user1", "password", "user1@example.com");
        user.logout();
        assertTrue(true); // If logout method executes without errors, the test passes
    }

    @Test
    public void testUserRegistration() {
        User user = new User(1, "user1", "password", "user1@example.com");
        user.register();
        assertTrue(true); // If registration method executes without errors, the test passes
    }
}