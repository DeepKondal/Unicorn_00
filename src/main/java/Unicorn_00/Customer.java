package Unicorn_00;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	private List<Product> cart;
	private Address address;

	public Customer(int userID, String username, String password, String email, boolean isLoggedIn) {
		super(userID, username, password, email);
		if (!isLoggedIn) {
			throw new IllegalStateException("Cannot create a Customer object for a user who is not logged in.");
		}
		this.cart = new ArrayList<>();
	}

	public Customer(int userID, String username, String password, String email, Address address, boolean isLoggedIn) {
		super(userID, username, password, email);
		if (!isLoggedIn) {
			throw new IllegalStateException("Cannot create a Customer object for a user who is not logged in.");
		}
		this.cart = new ArrayList<>();
		this.address = address;
	}


	public void addToCart(Product product) {
		cart.add(product);
	}

	public void removeFromCart(Product product) {
		// Remove the product from the cart
		cart.remove(product);
	}

	public void clearCart() {
		cart.clear();
	}

	public void placeOrder() {
		// Check if the cart is not empty
		if (!cart.isEmpty()) {
			// Create an order object using the products in the cart (for now, we'll just print a message)
			System.out.println("Placing order with the following products:");
			for (Product product : cart) {
				System.out.println(product.getName() + " - $" + product.getPrice());
				// Logic to update inventory, order database, etc., would go here in a real system
			}
			// Clear the cart after placing the order
			clearCart();
			System.out.println("Order placed successfully!");
		} else {
			System.out.println("Cart is empty. Cannot place an order.");
		}
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void deleteCustomer() {
		this.address = null;
	}
}
