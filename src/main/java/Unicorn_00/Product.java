package Unicorn_00;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
	private int productID;
	private String name;
	private double price;
	private String description;
	private int stockQuantity;
	private String image;
	private List<Category> categories;

	public Product(int productID, String name, double price, String description, int stockQuantity, String image) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stockQuantity = stockQuantity;
		this.image = image;
		this.categories = new ArrayList<>();
	}


	public void updateStock(int quantity) {
		stockQuantity += quantity;
	}

	public double getPrice() {
		return price;
	}

	public int getProductID() {
		return productID;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public String getImage() {
		return image;
	}

	public String getProductDetails() {
		// Format product details as a string
		return "Product ID: "+ productID +"\nName: "+name+"\nPrice: $"+price+"\nDescription: "+description+"\nStock Quantity: "+stockQuantity+"\nImage: "+image;
	}

	public void addCategory(Category category) {
		categories.add(category);
	}

	public void removeCategory(Category category) {
		categories.remove(category);
	}

	public List<Category> getCategories() {
		return categories;
	}
}
