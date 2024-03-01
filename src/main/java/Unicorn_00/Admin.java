package Unicorn_00;

public class Admin extends User {
	private int adminID;
	private Inventory inventory;

	public Admin(int userID, String username, String password, String email, int adminID) {
		super(userID, username, password, email);
		this.adminID = adminID;
		this.inventory = new Inventory();
	}

	public void addProduct(Product product) {
		// Add the product to the inventory
		inventory.updateStock(product.getProductID(), product);
		System.out.println("Product added to inventory: " + product.getName());
	}

	public void removeProduct(int productId) {
		// Remove the product from the inventory
		// Implement the logic to remove the product using the inventory object
		System.out.println("Product removed from inventory: " + productId);
	}

	public void updateProduct(int productId, Product updatedProduct) {
		// Update the product in the inventory
		// Implement the logic to update the product using the inventory object
		System.out.println("Product updated in inventory: " + updatedProduct.getName());
	}

	public void processOrder(Order order) {
		// Logic to process an order, such as updating order status, inventory, etc.
	}

	public void generateSalesReport() {
		// Logic to generate sales report
		System.out.println(("Sales report generated!"));
	}

	// Getter and setter for adminID
	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
}
