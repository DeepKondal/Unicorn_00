package Unicorn_00;

import java.util.Date;

public class Discount {
	private int discountID;
	private double percentage;
	private Date validUntil;

	public Discount(int discountID, double percentage, Date validUntil) {
		this.discountID = discountID;
		this.percentage = percentage;
		this.validUntil = validUntil;
	}

	public int getDiscountID() {
		return discountID;
	}

	public void setDiscountID(int discountID) {
		this.discountID = discountID;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public boolean isValid() {
		// Check if the discount is currently valid based on the validUntil date
		Date currentDate = new Date();
		return validUntil.after(currentDate);
	}
}
