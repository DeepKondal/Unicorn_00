package Unicorn_00;

public class Login {
    private Authentication authentication;

    public Login() {
        this.authentication = new Authentication();
    }

    public boolean loginUser(String username, String password) {
        // Call the authenticateUser method from the Authentication class
        return authentication.authenticateUser(username, password);
    }
}
