package Unicorn_00;

import java.math.BigDecimal;

public class CartItem {
	private int quantity;
	private BigDecimal subTotal;
	private Product product;

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		calculateSubTotal();
	}

	public void updateQuantity(int newQuantity) {
		this.quantity = newQuantity;
		calculateSubTotal();
	}

	private void calculateSubTotal() {
		BigDecimal pricePerItem = product.getPrice();
		subTotal = pricePerItem.multiply(BigDecimal.valueOf(quantity));
	}

	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
