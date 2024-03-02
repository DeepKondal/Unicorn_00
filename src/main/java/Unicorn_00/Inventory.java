package Unicorn_00;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Inventory {
	private List<Product> products;
	private Date lastUpdated;

	public Inventory() {
		this.lastUpdated = new Date();
		this.products = initializeInventory();
	}

	private List<Product> initializeInventory() {
		List<Product> productList = new ArrayList<>();
		// Hardcoded initial products
		productList.add(new Product(101, "Product 1", BigDecimal.valueOf(10.99), "Description 1", 50, "image1.jpg"));
		productList.add(new Product(102, "Product 2", BigDecimal.valueOf(20.99), "Description 2", 30, "image2.jpg"));
		productList.add(new Product(103, "Product 3", BigDecimal.valueOf(15.99), "Description 3", 40, "image3.jpg"));
		return productList;
	}

	public void addProduct(Product product) {
		// Check if the product ID already exists in the inventory
		if (findProductById(product.getProductID()) != null) {
			System.out.println("Product with ID " + product.getProductID() + " already exists in the inventory. Cannot add.");
			return;
		}

		// Add the product to the inventory
		products.add(product);
		System.out.println("Product added to inventory: "+product.getProductID() + " " + product.getName());
		updateLastUpdated();
	}

	public void removeProduct(int productId) {
		// Find and remove product by ID
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getProductID() == productId) {
				iterator.remove();
				System.out.println("Product removed from inventory: "+product.getProductID() + " " +product.getName());
				return;
			}
		}
		System.out.println("Product with ID " + productId + " not found in inventory.");
	}

	public void updateProduct(int productId, Product updatedProduct) {
		Product productToUpdate = findProductById(productId);
		if (productToUpdate != null) {
			products.remove(productToUpdate);
			products.add(updatedProduct);
			System.out.println("Product updated in inventory: " + updatedProduct.getName());
			updateLastUpdated();
		} else {
			System.out.println("Product with ID " + productId + " not found in inventory.");
		}
	}

	public boolean checkAvailability(int productId) {
		Product productToCheck = findProductById(productId);
		if (productToCheck != null) {
			System.out.println("Product is available in the inventory.");
			return true;
		} else {
			System.out.println("Product is not available in the inventory.");
			return false;
		}
	}

	private Product findProductById(int productId) {
		for (Product product : products) {
			if (product.getProductID() == productId) {
				return product;
			}
		}
		return null;
	}

	private void updateLastUpdated() {

		this.lastUpdated = new Date();
	}

	// Getters for products and lastUpdated
	public List<Product> getProducts() {
		return products;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}
}
