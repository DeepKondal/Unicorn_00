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

	public ShoppingCart() {
		this.cartItems = new ArrayList<>();
	}

	public void addProduct(Product product, int quantity) {
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

	public Order checkout() {
		calculateTotal();
		Order customerOrder = new Order(cartItems, totalAmount);

		// Check if payment is successful, orderID generated.
		if (customerOrder.getOrderID() != null) {
			//order.viewOrder();
			return customerOrder;
		} else {
			return null;
		}
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