package Unicorn_00;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private static List<Category> allCategories = new ArrayList<>(); // Static list to track all categories
	private int categoryID;
	private String name;
	private List<Product> products;

	public Category(int categoryID, String name, String description) {
		if (!isCategoryUnique(name, categoryID)) {
			throw new IllegalArgumentException("Category name or ID is not unique.");
		}
		this.categoryID = categoryID;
		this.name = name;

		this.products = new ArrayList<>();
		allCategories.add(this);
	}

	public void addProduct(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Product cannot be null.");
		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		// Check if the name is already used by another category
		if (!isCategoryUnique(name,this.categoryID)) {
			throw new IllegalArgumentException("Category name must be unique.");
		}
		this.name = name;
	}

	private boolean isCategoryUnique(String name, int categoryID) {
		for (Category category : allCategories) {
			if (category.getName().equals(name) || category.getCategoryID() == categoryID) {
				return false; // Either name or ID is not unique
			}
		}
		return true; // Name and ID are both unique
	}

}
