package Unicorn_00;
import java.util.Date;
import java.util.UUID;

public class Payment {
	private UUID paymentID;
	private double paymentAmount; // Changed from EDouble to double for simplicity
	private Date paymentDate;
	private boolean paymentStatus;

	// Constructor
	public Payment(double paymentAmount) {
		this.paymentAmount = paymentAmount;
		processPayment();
	}

	public void processPayment(){
		this.paymentID = UUID.randomUUID();
		this.paymentDate = new Date();
		this.paymentStatus = true;
		//System.out.println("Payment processed successfully!");
	}

	// Getters and setters
	public UUID getPaymentID() {
		return paymentID;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public boolean getPaymentStatus() {
		return paymentStatus;
	}
}
