package Unicorn_00;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Discount {
	private String couponName;
	private double percentage;
	private Date validUntil;

	// Predefined discount coupon codes with percentages
	private static final Map<String, Double> predefinedDiscounts = new HashMap<>();
	static {
		predefinedDiscounts.put("DISCOUNT50", 50.0); // 50% discount coupon code
		predefinedDiscounts.put("DISCOUNT30", 30.0); // 30% discount coupon code
		// Add more predefined discount coupon codes as needed
	}

	public Discount(String couponName, double percentage, Date validUntil) {
		this.couponName = couponName;
		this.percentage = percentage;
		this.validUntil = validUntil;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
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

	public static boolean isPredefinedDiscount(String couponName) {
		return predefinedDiscounts.containsKey(couponName);
	}

	public static double getDiscountPercentage(String couponName) {
		return predefinedDiscounts.getOrDefault(couponName, 0.0);
	}
}
