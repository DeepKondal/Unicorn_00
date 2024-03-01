package Unicorn_00;

public class Address {
	private int addressID;
	private String street;
	private String city;
	private String postCode;
	private String country;

	public Address(int i, String s, String city, String number, String country) {
	}

	public Address() {

	}


	public void updateAddress() {
		// Logic to update address details
	}

	// Getters and setters for addressID, street, city, postCode, and country
	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
