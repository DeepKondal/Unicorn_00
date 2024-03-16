package Unicorn_00;

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
	private Shipment shipment;
	private Discount appliedDiscount;

	public Order(ShoppingCart shoppingCart, List<CartItem> cartItems) {
		this.cartItems = cartItems;
		this.orderAmount = calculateOrderAmount();
		this.orderID = UUID.randomUUID();
		this.status = false;
		this.appliedDiscount = null; // Initialize appliedDiscount to null initially
		placeOrder();
	}


	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public void viewOrder() {
		for (CartItem item : cartItems) {
			System.out.println("Item: " + item.getProduct().getName() + " Price: " + item.getProduct().getPrice()
					+ " Quantity: " + item.getQuantity() + " Subtotal: " + item.getSubTotal());
		}
	}

	public boolean itemsAllAvailable(List<CartItem> cartItems) {
		for (CartItem item : cartItems) {
			if (item.getProduct().getStockQuantity() < item.getQuantity()) {
				return false;
			}
		}
		return true;
	}

	public void placeOrder() {
		boolean itemsAvailable = itemsAllAvailable(cartItems);
		if (!cartItems.isEmpty() && itemsAvailable) {
			System.out.println("Your total amount is (including 1.5% tax) : $" + orderAmount + "\n");
			System.out.println("Proceed to select delivery method...");

			// Let the customer choose delivery method
			DeliveryChoice deliveryChoice = new DeliveryChoice();
			// Set the delivery method based on customer choice
			// Example: deliveryChoice.setDeliveryMethod("Home Delivery");
			deliveryChoice.setDeliveryMethod("Pickup"); // Assuming customer chooses Home Delivery
			System.out.println("User choose :" + deliveryChoice.getDeliveryMethod());
			// Calculate delivery cost
			deliveryChoice.calculateCost(orderAmount);

			// Create a new Shipment object with the generated shipment ID, order ID, and delivery choice
			shipment = new Shipment(orderID.toString(), deliveryChoice); // Using the Shipment class to generate unique shipment IDs

			// Proceed with payment and other order processing only if the delivery method is finalized
			if (deliveryChoice.getDeliveryMethod() != null && !deliveryChoice.getDeliveryMethod().isEmpty()) {
				Payment payment = new Payment(orderAmount + deliveryChoice.getDeliveryCost());
				this.paymentID = payment.getPaymentID();

				if (payment.getPaymentStatus()) {
					orderDate = new Date();
					status = true;
				}
			} else {
				System.out.println("Please choose a delivery method before proceeding with payment!");
			}
		} else {
			System.out.println("Cart is empty or items are not available, could not place order!");
		}
	}

	public Shipment getShipment() {
		return shipment;
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

	public Discount applyApplicableDiscount(String couponName) {
		// Check if the coupon name is a predefined discount
		if (!Discount.isPredefinedDiscount(couponName)) {
			System.out.println("Invalid discount coupon name.");
			return null; // Return null if the coupon name is invalid
		}

		// Get the discount percentage based on the coupon name
		double discountPercentage = Discount.getDiscountPercentage(couponName);

		// Check if the discount percentage exceeds the maximum limit of 50%
		if (discountPercentage > 50.0) {
			System.out.println("Discount percentage exceeds the maximum limit of 50%. Applying maximum discount.");
			discountPercentage = 50.0;
		}

		// Create the Discount object with the provided percentage and current date
		Discount discount = new Discount(couponName, discountPercentage, new Date());

		// Apply the discount to the order
		appliedDiscount = discount;
		orderAmount *= (1 - (discountPercentage / 100));

		return discount;
	}

	private double calculateOrderAmount() {
		double totalAmount = 0.0;
		for (CartItem item : cartItems) {
			// Calculate subtotal including tax (assuming 1.5% tax)
			double subtotal = item.getProduct().getPrice() * item.getQuantity() * 1.015;
			totalAmount += subtotal;
		}
		return totalAmount;
	}


	public UUID getPaymentID() {
		return paymentID;
	}
}
