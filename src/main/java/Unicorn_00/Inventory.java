package Unicorn_00;

import java.util.Date;

public class Inventory {
	private int inventoryID;
	private Date lastUpdated;

	public void updateStock(int productId, Product product) {
		// Logic to update stock quantity of the specified product
		// For simplicity, let's just print a message
		System.out.println("Stock updated for product ID " + productId + ": " + product.getName());
	}

	public void checkAvailability(boolean available) {
		// Logic to check if the product is available in the inventory
		if (available) {
			System.out.println("Product is available in the inventory.");
		} else {
			System.out.println("Product is not available in the inventory.");
		}
	}

	// Getters and setters for inventoryID and lastUpdated
	public int getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
