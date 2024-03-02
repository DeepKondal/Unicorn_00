package Unicorn_00;

public class Login {
    private Authentication authentication;
    private boolean isLoggedIn;

    public Login(Authentication authentication) {
        this.authentication = authentication;
        this.isLoggedIn = false;
    }

    public boolean loginUser(String username, String password) {
        try {
            // Check if the user is already logged in
            if (isLoggedIn) {
                System.out.println("User is already logged in.");
                return false;
            }

            // Call the authenticateUser method from the Authentication class
            boolean authenticated = authentication.authenticateUser(username, password);
            // this means user is registered with us
            if (authenticated) {
                isLoggedIn = true; // Set isLoggedIn to true upon successful login
                System.out.println("User logged in successfully.");
                //this means user is not registered with us.
            } else {
                System.out.println("Login failed. Invalid credentials.");
            }
            return authenticated;
        } catch (Exception e) {
            System.err.println("An error occurred during login: " + e.getMessage());
            return false;
        }
    }


    public boolean isLoggedIn() {
       return isLoggedIn;
    }

    public void logout() {
        isLoggedIn = false;
        System.out.println("User logged out successfully.");
    }
}