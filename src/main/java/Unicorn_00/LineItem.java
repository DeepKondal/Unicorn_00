package Unicorn_00;

public class LineItem {
    private Product product;
    private int quantity;
    private double price; // Assuming price is a double value

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

    }
    // Constructor
    public LineItem(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public double getSubTotal() {

        return quantity * price;
    }

    // Getters and setters for product, quantity, and price
    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {

        this.product = product;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }
}
