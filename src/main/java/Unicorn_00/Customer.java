package Unicorn_00;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	private List<Product> cart;
	private String[] address;

	public Customer(int userID, String username, String password, String email) {
		super(userID, username, password, email);
		this.cart = new ArrayList<>();
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

	// We can add Getters and setters for address here
}
