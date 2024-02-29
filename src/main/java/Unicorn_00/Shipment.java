package Unicorn_00;

public class Shipment {
	private int shipmentID;
	private String orderID;
	private String deliveryMethod;
	private DeliveryChoice deliveryChoice;

	// Constructor
	public Shipment(int shipmentID, String orderID, String deliveryMethod, DeliveryChoice deliveryChoice) {
		this.shipmentID = shipmentID;
		this.orderID = orderID;
		this.deliveryMethod = deliveryMethod;
		this.deliveryChoice = deliveryChoice;
	}

	// Getters and setters
	public int getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(int shipmentID) {
		this.shipmentID = shipmentID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public DeliveryChoice getDeliveryChoice() {
		return deliveryChoice;
	}

	public void setDeliveryChoice(DeliveryChoice deliveryChoice) {
		this.deliveryChoice = deliveryChoice;
	}

	// Method to update shipping information
	public void updateShippingInfo() {
		// Logic to update shipping information
	}
}
