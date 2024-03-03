package Unicorn_00;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
	private UUID orderID;
	private Date orderDate;
	private boolean status;
	private List<CartItem> cartItems;
	private double orderAmount;
	private UUID paymentID;

	public Order(List <CartItem> cartItems, double orderAmount) {
		this.cartItems = new ArrayList<>();
		this.orderAmount = orderAmount;
		placeOrder();
	}

	public void viewOrder() {
		for (CartItem item : cartItems) {
			System.out.println("Item: "+item.getProduct().getName()+" Price: "+item.getProduct().getPrice()+" Quantity: "+item.getQuantity()+" Subtotal: "+item.getSubTotal());
		}
	}

	public void placeOrder() {
		System.out.println("Your total amount is: $" + orderAmount);
        System.out.println("Proceed to payment...");

		//initiate payment object
		Payment payment = new Payment(orderAmount);
		//store the ID for reference
		this.paymentID = payment.getPaymentID();

		//generate the OrderID.
		if (payment.getPaymentStatus()){
			orderID = UUID.randomUUID();
			orderDate = new Date();
			status = true;
			//add the payment to payment history.


		}
		// Logic to place the order
		// For simplicity, let's just print a message
		//System.out.println("Order placed successfully!");
	}

	public UUID getOrderID() {
		return orderID;
	}

	public void setOrderID(UUID orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public UUID getPaymentID() {
		return paymentID;
	}
}
