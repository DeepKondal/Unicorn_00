package Unicorn_00;

public class User {
	private int userID;
	private String username;
	private String password;
	private String email;
	private boolean isAdmin;

	public User(int userID, String username, String password, String email, boolean isAdmin) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isAdmin = isAdmin || (userID >= 1000) ;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public String getUserType() {
		return isAdmin ? "Admin" : "Customer";
	}

	// Getters and setters for userID, username, password, and email
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		if (password != null && !password.isEmpty()) {
			return password; // No need for additional formatting here
		} else {
			return "No Password set for user";
		}
	}

	public void setPassword(String password) {
		if (password.length() >= 8 && !password.equals(password.toLowerCase()) && !password.equals(password.toUpperCase()) && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
			this.password = password;
		} else {
			System.out.println("Password does not meet complexity requirements.");
		}
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}