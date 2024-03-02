package Unicorn_00;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private List<User> registeredUsers;
    private int lastUserID;
    private Authentication authentication;

    public Registration(Authentication authentication) {
        this.registeredUsers = new ArrayList<>();
        this.lastUserID = 0; // Initialize with 0
        this.authentication = authentication;
    }

    public void registerUser(String username, String password, String email) {
        // Increment the last assigned user ID to generate a new unique ID
        lastUserID++;

        // Perform registration logic
        User newUser = new User(lastUserID, username, password, email);
        registeredUsers.add(newUser);

        // Update the Authentication instance with the new user
        authentication.addUser(username, password);

        System.out.println("User registered successfully!");
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public Authentication getAuthentication() {
        return authentication;
    }
}
