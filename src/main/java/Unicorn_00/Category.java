package Unicorn_00;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private int categoryID;
	private String name;
	private String description;
	private List<Product> products;

	public Category() {
		this.products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	// Getters and setters for categoryID, name, and description
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
