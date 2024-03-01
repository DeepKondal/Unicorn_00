package Unicorn_00;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private List<User> registeredUsers;
    private int lastUserID;

    public Registration() {
        this.registeredUsers = new ArrayList<>();
        this.lastUserID = 0; // Initialize with 0
    }

    public void registerUser(String username, String password, String email) {
        // Increment the last assigned user ID to generate a new unique ID
        lastUserID++;

        // Perform registration logic
        User newUser = new User(lastUserID, username, password, email);
        registeredUsers.add(newUser);
        System.out.println("User registered successfully!");
    }
    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }
}
