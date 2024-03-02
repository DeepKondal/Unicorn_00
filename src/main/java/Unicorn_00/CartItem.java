package Unicorn_00;

import java.text.DecimalFormat;

public class CartItem {
	private int quantity;
	private Product product;
	private double subTotal;

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		calculateSubTotal();
	}

	public void updateQuantity(int newQuantity) {
		this.quantity = newQuantity;
		calculateSubTotal();
	}

	public void calculateSubTotal() {
		double pricePerItem = product.getPrice();
		// Rounding off to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");

		this.subTotal = Double.valueOf(df.format(pricePerItem * quantity));
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
}
