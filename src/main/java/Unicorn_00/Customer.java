package Unicorn_00;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer extends User {
	private ShoppingCart cart;
	private List <Order> orders;
	private Address address;

	public Customer(int userID, String username, String password, String email, boolean isLoggedIn) {
		super(userID, username, password, email);
		if (!isLoggedIn) {
			throw new IllegalStateException("Cannot create a Customer object for a user who is not logged in.");
		}
		this.cart = new ShoppingCart();
		this.orders = new ArrayList<>();
	}

	public Customer(int userID, String username, String password, String email, Address address, boolean isLoggedIn) {
		super(userID, username, password, email);
		if (!isLoggedIn) {
			throw new IllegalStateException("Cannot create a Customer object for a user who is not logged in.");
		}
		this.cart = new ShoppingCart();
		this.orders = new ArrayList<>();
	}


	public void addToCart(Product product, int quantity) {
		cart.addProduct(product, quantity);
	}

	public void removeFromCart(Product product) {
		// Remove the product from the cart
		cart.removeProduct(product.getProductID());
	}

	public Order placeOrder() {
		// Check if the cart is not empty
		if (!cart.isEmpty()) {
			// Create an order object using the products in the cart (for now, we'll just print a message)
			System.out.println("Placing order with the following products:");
			for (CartItem cartItem : cart.getCartItems()) {
				System.out.println(cartItem.getProduct().getName() + " - $" + cartItem.getProduct().getPrice() + "  -  "+cartItem.getQuantity()+" units");
				// Logic to update inventory, order database, etc., would go here in a real system
			}
			Order customerOrder = cart.checkout();
			if (customerOrder == null){
				System.out.println("Payment failed");
				return null;
			}
			else{
				System.out.println("Order placed successfully! with OrderID: "+customerOrder.getOrderID());
				// Clear the cart after placing the order
				cart.clearCart();
				orders.add(customerOrder);
				return customerOrder;
			}
		}
		else{
			System.out.println("Cart empty, cant place order");
			return null;
		}
	}

	public void clearCart(){
		cart.clearCart();
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

		public List <Order> getOrders() {
		return orders;
	}

	public void cancelOrder(UUID orderID){
		orders.removeIf(order -> order.getOrderID() == orderID);
	}

	public ShoppingCart getCart() {
		return cart;
	}
}
