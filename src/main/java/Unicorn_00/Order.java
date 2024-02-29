package Unicorn_00;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private int orderID;
	private Date orderDate;
	private String status;
	private List<LineItem> lineItems;

	public Order() {
		lineItems = new ArrayList<>();
	}

	public void addLineItem(LineItem lineItem) {
		lineItems.add(lineItem);
	}

	public void removeLineItem(LineItem lineItem) {
		lineItems.remove(lineItem);
	}

	public void placeOrder() {
		// Logic to place the order
		// For simplicity, let's just print a message
		System.out.println("Order placed successfully!");
	}

	public void cancelOrder() {
		// Logic to cancel the order
		// For simplicity, let's just print a message
		System.out.println("Order cancelled successfully!");
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
