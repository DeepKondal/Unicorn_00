package Unicorn_00;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class RegistrationTest {

    @Test
    public void testRegisterUser() {
        Authentication authentication = new Authentication();
        // Create a new Registration instance
        Registration registration = new Registration(authentication);

        // Call the registerUser method
        registration.registerUser("testUser", "testPassword", "test@example.com");

        // Get the list of registered users
        List<User> registeredUsers = registration.getRegisteredUsers();

        // Check if the registered user list contains the newly registered user
        boolean userRegistered = false;
        for (User user : registeredUsers) {
            if (user.getUsername().equals("testUser") && user.getEmail().equals("test@example.com")) {
                userRegistered = true;
                break;
            }
        }

        // Assert that the user is registered
        assertTrue(userRegistered);
    }
}
