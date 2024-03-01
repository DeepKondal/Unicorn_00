package Unicorn_00;
public class Logout {
    public void logoutUser(Login login) {
        try {
            // Logic to logout user
            login.logout(); // Call the logout method from the Login class to update isLoggedIn

        } catch (Exception e) {
            System.err.println("An error occurred during logout: " + e.getMessage());
        }
    }
}
