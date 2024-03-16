package Unicorn_00;

import java.util.UUID;

public class Shipment {
	private String shipmentID;
	private String orderID;
	private DeliveryChoice deliveryChoice;

	public Shipment(String orderID, DeliveryChoice deliveryChoice) {
		this.shipmentID = UUID.randomUUID().toString();
		this.orderID = orderID;
		this.deliveryChoice = deliveryChoice;
	}

	public String getShipmentID() {
		return shipmentID;
	}

	public void setShipmentID(String shipmentID) {
		this.shipmentID = shipmentID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
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
