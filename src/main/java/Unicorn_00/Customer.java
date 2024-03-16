package Unicorn_00;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer extends User {
	private ShoppingCart cart;
	private List<Order> orders;
	private Address address;

	public Customer(int userID, String username, String password, String email, boolean isLoggedIn) {
		super(userID, username, password, email, false); // Set isAdmin flag to false for Customer objects
		if (!isLoggedIn) {
			throw new IllegalStateException("Cannot create a Customer object for a user who is not logged in.");
		}
		this.cart = new ShoppingCart();
		this.orders = new ArrayList<>();
	}

	public Customer(int userID, String username, String password, String email, Address address, boolean isLoggedIn) {
		super(userID, username, password, email, false); // Set isAdmin flag to false for Customer objects
		if (!isLoggedIn) {
			throw new IllegalStateException("Cannot create a Customer object for a user who is not logged in.");
		}
		this.cart = new ShoppingCart();
		this.orders = new ArrayList<>();
		this.address = address;
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
			// Calculate the total amount before applying the discount
			double orderAmountBeforeDiscount = cart.getTotalAmount();

			// Create an order object using the products in the cart
			Order customerOrder = new Order(cart, new ArrayList<>(cart.getCartItems()));

			// Proceed with checkout
			if (cart.checkout(customerOrder)) {
				double taxAmount = orderAmountBeforeDiscount * 0.015;
				double orderAmountAfterTax = orderAmountBeforeDiscount + taxAmount;
				customerOrder.setOrderAmount(orderAmountAfterTax); // Set the order amount including tax

				// Apply a discount to the order
				Discount discount = customerOrder.applyApplicableDiscount("DISCOUNT30");
				if (discount != null) {
					System.out.println("Applied Discount: " + discount.getCouponName());
				}

				// Display order details

				System.out.println("Order Amount Before Discount: $" + orderAmountBeforeDiscount);
				System.out.println("Tax Amount: $" + taxAmount);
				int BeforeDiscount = (int) (orderAmountBeforeDiscount + taxAmount);
				System.out.println("Order Amount with Tax: $" + BeforeDiscount);
				System.out.println("Final Discounted amount: $" + customerOrder.getOrderAmount());
				System.out.println("Order placed successfully! with OrderID: " + customerOrder.getOrderID());

				// Clear the cart after placing the order
				cart.clearCart();
				orders.add(customerOrder);
				return customerOrder;
			} else {
				System.out.println("Payment failed");
				return null;
			}
		} else {
			System.out.println("Cart empty, can't place order");
			return null;
		}
	}


	public void clearCart() {
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

	public List<Order> getOrders() {
		return orders;
	}

	public void cancelOrder(UUID orderID) {
		orders.removeIf(order -> order.getOrderID().equals(orderID));
	}

	public ShoppingCart getCart() {
		return cart;
	}
}
