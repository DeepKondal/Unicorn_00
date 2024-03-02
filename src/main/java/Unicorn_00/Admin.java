package Unicorn_00;

public class Admin extends User {
	private int adminID;
	private Inventory inventory;

	public Admin(int userID, String username, String password, String email, int adminID, Inventory inventory) {
		super(userID, username, password, email);
		this.adminID = adminID;
		this.inventory = inventory;
	}

	public void addProduct(Product product) {

		inventory.addProduct(product);
	}

	public void removeProduct(int productId) {
		inventory.removeProduct(productId);

	}

	public void updateProduct(int productId, Product updatedProduct) {
		inventory.updateProduct(productId, updatedProduct);
	}

	public boolean checkProductAvailability(int productId) {
		inventory.checkAvailability(productId);
		return true;
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
