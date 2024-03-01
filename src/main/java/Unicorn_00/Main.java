package Unicorn_00;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Register a new user
        Registration registration = new Registration();
        registration.registerUser("John", "password1", "user1@example.com");

        //Authentication instance
        Authentication authentication = new Authentication();

        //Login with the registered user credentials
        Login login = new Login(authentication);
        boolean loggedIn = login.loginUser("John", "password1");

        if (loggedIn) {
            System.out.println("User is here!!");

            //Perform some actions while logged in like create a Customer instance
            Customer customer = new Customer(1, "John", "password1", "john@example.com");

            //Logout
            Logout logout = new Logout();
            logout.logoutUser(login);

            //Trying to log in again (should fail after logout)
            if (login.isLoggedIn()) {
                System.out.println("User is already logged in.1");
            } else {
                loggedIn = login.loginUser("John", "password1");
                if (!loggedIn) {
                    System.out.println("User cannot log in. User is already logged out.");
                } else {
                    System.out.println("User has logged in again!");
                    // User is logged in as a customer
                    System.out.println("User name is : " +customer.getUsername());
                }
            }

        }
        }
    }

