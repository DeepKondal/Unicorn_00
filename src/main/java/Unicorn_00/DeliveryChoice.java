package Unicorn_00;

public class DeliveryChoice {
	private String deliveryMethod; // ["Pickup","Home Delivery"]
	private double deliveryCost;

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		if (deliveryMethod.equalsIgnoreCase("Pickup") || deliveryMethod.equalsIgnoreCase("Home Delivery")) {
			this.deliveryMethod = deliveryMethod;
		} else {
			System.out.println("Invalid delivery method!");
		}
	}

	public void calculateCost(double orderAmount) {
		if (deliveryMethod.equalsIgnoreCase("Home Delivery")) {
			deliveryCost = orderAmount * 0.02; // 2% of total price for Home Delivery
		} else if (deliveryMethod.equalsIgnoreCase("Pickup")) {
			deliveryCost = orderAmount * 0.01; // 1% of total price for PickUp Delivery
		}
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void shipOrder() {
		// Logic to ship the order using the chosen delivery method
	}
}

