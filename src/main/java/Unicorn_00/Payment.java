package Unicorn_00;
import java.util.Date;
public class Payment {
	private int paymentID;
	private double amount; // Changed from EDouble to double for simplicity
	private Date paymentDate;
	private boolean status;

	// Constructor
	public Payment(int paymentID, double amount, Date paymentDate, boolean status) {
		this.paymentID = paymentID;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.status = status;
	}

	// Getters and setters
	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// Method to process the payment
	public void processPayment() {
		// Logic to process the payment
		// For simplicity, let's just print a message
		System.out.println("Payment processed successfully!");
	}
}
