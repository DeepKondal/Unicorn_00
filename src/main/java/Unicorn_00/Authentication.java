package Unicorn_00;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
	private Map<String, String> users; // Map of usernames to passwords

	public Authentication() {
		users = new HashMap<>();
		// For simplicity, let's add some predefined users (username:password)
		users.put("user1", "password1");
		users.put("user2", "password2");
		users.put("John", "password1");
		// Add more users as needed
	}

	public boolean authenticateUser(String username, String password) {
		// Check if the username exists in the map and if the provided password matches the stored password
		return users.containsKey(username) && users.get(username).equals(password);
	}
}
