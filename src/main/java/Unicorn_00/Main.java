package Unicorn_00;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create an instance of Authentication
        Authentication authentication = new Authentication();

        // Create instances of Login, Logout, and Registration
        Login login = new Login(authentication);
        Logout logout = new Logout();
        Registration registration = new Registration(authentication);

        // Register a user
        registration.registerUser("user1", "password1", "user1@example.com");

        // Attempt to log in with correct credentials
        login.loginUser("user1", "password1");
        Customer customer = new Customer(1, "user1", "password1", "user1@example.com",login.isLoggedIn());
        System.out.println("User name is : " +customer.getUsername());
        // Log out the user
        logout.logoutUser(login);
        // Attempt to log in with incorrect credentials
        login.loginUser("user1", "wrongpassword");
    }
}

