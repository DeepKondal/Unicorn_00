package Unicorn_00;
import java.util.HashMap;
import java.util.Map;


public class Authentication {
	private Map<String, String> users; // Map of usernames to hashed passwords

	public Authentication() {
		users = new HashMap<>();
		// For simplicity, let's add some predefined users (username:password)
		users.put("user1", "password1");
		users.put("user2", "password2");
		// Add more users as needed
	}

	public boolean authenticateUser(String username, String password) {
		// Check if the username exists in the map and if the provided password matches the hashed password
		if (users.containsKey(username)) {
			String hashedPassword = hashPassword(password); // Hash the provided password
			return users.get(username).equals(hashedPassword);
		}
		return false; // Username does not exist
	}

	private String hashPassword(String password) {
		// In a real system, you would use a secure hashing algorithm like bcrypt
		// For simplicity, let's just return the password as-is
		return password;
	}
}
