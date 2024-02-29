package Unicorn_00;

public class Review {
	private int reviewID;
	private int rating;
	private String comment;
	private int productID;

	// Constructor
	public Review(int reviewID, int rating, String comment, int productID) {
		this.reviewID = reviewID;
		this.rating = rating;
		this.comment = comment;
		this.productID = productID;
	}

	// Getters and setters
	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	// Methods to add, edit, and delete reviews
	public void addReview() {
		// Logic to add a review
	}

	public void editReview() {
		// Logic to edit a review
	}

	public void deleteReview() {
		// Logic to delete a review
	}
}
