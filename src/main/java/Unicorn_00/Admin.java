package Unicorn_00;

public class Admin extends User {
	private int adminID;

	public Admin(int userID, String username, String password, String email, int adminID) {
		super(userID, username, password, email);
		this.adminID = adminID;
	}

	public void addProduct(Product product) {
		// Logic to add a new product to the inventory
	}

	public void removeProduct(int productId) {
		// Logic to remove a product from the inventory by ID
	}

	public void updateProduct(int productId, Product updatedProduct) {
		// Logic to update product details in the inventory by ID
	}

	public void processOrder(Order order) {
		// Logic to process an order, such as updating order status, inventory, etc.
	}

	public void generateSalesReport() {
		// Logic to generate sales report
	}

	// Getter and setter for adminID
	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
}
