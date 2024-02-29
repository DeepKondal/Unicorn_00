package Unicorn_00;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int userID;
	private String username;
	private String password;
	private String email;

	public User(int userID, String username, String password, String email) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public void login() {
		System.out.println("User logged in.");
	}

	public void logout() {
		System.out.println("User logged out.");
	}

	public void register() {
		System.out.println("User registered.");
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
