package Unicorn_00;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Authentication {
	private Map<String, String> users; // Map of usernames to passwords
	private List<User> registeredUsers;
	private boolean isLoggedIn;
	private User currentUser;
	private int userIDCounter;

	public Authentication() {
		users = new HashMap<>();
		registeredUsers = new ArrayList<>();
		isLoggedIn = false;
		currentUser = null;
		userIDCounter = users.size(); // Initialize user ID counter based on 'users' map size

		// For simplicity, let's add some predefined users (username:password)
		users.put("user1", "password1");
		users.put("user2", "password2");
		users.put("John", "password");
		// Add more users as needed
	}

	public void registerUser(String username, String password, String email, boolean isAdmin) {
		// Check if the username already exists
		if (users.containsKey(username)) {
			System.out.println("Username " + username + " already exists. Please choose a different username.");
			return;
		}

		// Perform registration logic
		User newUser;
		if (users.size() < 3) { // Assign user IDs 1, 2, 3 for users from the 'users' map
			newUser = new User(users.size() + 1, username, password, email, false);
		} else {
			if (isAdmin) {
				newUser = new Admin(username, password, email, new Inventory());
			} else {
				newUser = new User(userIDCounter + 1, username, password, email, false);
			}
			userIDCounter++; // Increment user ID counter for registered users
		}
		registeredUsers.add(newUser);
		users.put(username, password);
		System.out.println("User registered successfully!");
	}



	public boolean loginUser(String username, String password) {
		try {
			// Check if the user is already logged in
			if (isLoggedIn) {
				System.out.println("User is already logged in.");
				return false;
			}

			// Check if the username exists in the map and if the provided password matches
			if (users.containsKey(username) && users.get(username).equals(password)) {
				// Get the user object based on the username
				User user = getUserByUsername(username);

				// Check if the user is an admin
				if (user instanceof Admin) {
					System.out.println("Admin logged in successfully.");
				} else {
					System.out.println("User logged in successfully.");
				}

				isLoggedIn = true;
				currentUser = user;
				return true;
			} else {
				System.out.println("Login failed. Invalid credentials.");
				return false;
			}
		} catch (Exception e) {
			System.err.println("An error occurred during login: " + e.getMessage());
			return false;
		}
	}


	public void logout() {
		if (isLoggedIn) {
			isLoggedIn = false;
			currentUser = null;
			System.out.println("User logged out successfully.");
		} else {
			System.out.println("No user is currently logged in.");
		}
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public List<User> getRegisteredUsers() {
		List<User> allUsers = new ArrayList<>();

		// Add all registered users (both customers and admins)
		allUsers.addAll(registeredUsers);

		// Add predefined users from the users map if they are not already registered
		for (Map.Entry<String, String> entry : users.entrySet()) {
			String username = entry.getKey();
			String password = entry.getValue();

			// Check if the user is already registered
			boolean isRegistered = false;
			for (User user : registeredUsers) {
				if (user.getUsername().equals(username)) {
					isRegistered = true;
					break;
				}
			}

			// Create a new user object and add it to the list if not already registered
			if (!isRegistered) {
				User user = new User(allUsers.size() + 1, username, password, "", false);
				allUsers.add(user);
			}
		}

		return allUsers;
	}






	private User getUserByUsername(String username) {
		for (User user : registeredUsers) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
}








/*

public class Authentication {
	private Map<String, String> users; // Map of usernames to passwords

	public Authentication() {
		users = new HashMap<>();
		// For simplicity, let's add some predefined users (username:password)
		users.put("user1", "password1");
		users.put("user2", "password2");
		users.put("John", "password");
		// Add more users as needed
	}

	public boolean authenticateUser(String username, String password) {
		// Check if the username exists in the map and if the provided password matches the stored password
		return users.containsKey(username) && users.get(username).equals(password);
	}

	public void addUser(String username, String password) {
		users.put(username, password);
	}

	// Getter for users map
	public Map<String, String> getUsers() {
		return users;
	}
}


 */