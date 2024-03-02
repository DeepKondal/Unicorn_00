package Unicorn_00;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart {
	private int cartID;
	private Date creationDate;
	private List<LineItem> lineItems;

	public ShoppingCart() {
		lineItems = new ArrayList<>();
	}

	public void addProduct(Product product, int quantity) {
		// Check if the product is already in the cart
		for (LineItem item : lineItems) {
			if (item.getProduct().getProductID() == product.getProductID()) {
				// If the product is already in the cart, update the quantity
				item.setQuantity(item.getQuantity() + quantity);
				return;
			}
		}
		// If the product is not already in the cart, add it as a new line item
		LineItem lineItem = new LineItem(product, quantity);
		lineItems.add(lineItem);
	}

	public void removeProduct(int productId) {
		// Remove the line item associated with the specified product ID
		lineItems.removeIf(item -> item.getProduct().getProductID() == productId);
	}

	public void calculateTotal() {
		double total = 0.0;
		for (LineItem item : lineItems) {
			total += item.getSubTotal();
		}
		System.out.println("Total cost of items in shopping cart: $" + total);
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
}