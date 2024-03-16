package Unicorn_00;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart {
	private int cartID;
	private Date creationDate;
	private List<CartItem> cartItems;
	private double totalAmount;
	private User currentUser;

	public ShoppingCart() {
		this.cartItems = new ArrayList<>();
	}

	public void addProduct(Product product, int quantity) {
		// Check if adding this product will exceed the maximum limit
		if (cartItems.size() + 1 <= 30) {
			// Check if the product is already in the cart
			for (CartItem item : cartItems) {
				if (item.getProduct().getProductID() == product.getProductID()) {
					// If the product is already in the cart, update the quantity
					item.setQuantity(item.getQuantity() + quantity);
					return;
				}
			}
			// If the product is not already in the cart, add it as a new line item
			CartItem cartItem = new CartItem(product, quantity);
			cartItems.add(cartItem);
			calculateTotal();

		} else {
			// Handle case where adding the product will exceed the maximum limit
			System.out.println("Cannot add more than 30 products to the cart.");
		}
	}


	public void removeProduct(int productId) {
		// Remove the line item associated with the specified product ID
		cartItems.removeIf(item -> item.getProduct().getProductID() == productId);
	}

	public void calculateTotal() {
		double total = 0.0;
		for (CartItem item : cartItems) {
			total += item.getSubTotal();
		}
		// Rounding off to two decimal places
		DecimalFormat df = new DecimalFormat("#.##");
		this.totalAmount = Double.valueOf(df.format(total));
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public boolean checkout(Order order) {
		if (!isEmpty()) {
			// Apply the discount and tax using the getOrderAmount method
			double orderAmountAfterDiscountAndTax = order.getOrderAmount();

			order.setOrderAmount(orderAmountAfterDiscountAndTax); // Update the order amount
			order.setOrderDate(new Date());
			order.setStatus(true);
			return true;
		} else {
			System.out.println("Cart is empty, cannot proceed with checkout.");
			return false;
		}
	}






	public boolean isEmpty(){
		if (cartItems.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}

	public void clearCart(){
		this.cartItems = new ArrayList<>();
		this.totalAmount = 0.0;
	}

	// Getters and setters for cartID and creationDate
	public int getCartID() {

		return cartID;
	}

	public void setCartID(int cartID) {

		this.cartID = cartID;
	}

	public Date getCreationDate() {

		return creationDate;
	}

	public void setCreationDate(Date creationDate) {

		this.creationDate = creationDate;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

}

