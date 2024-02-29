package Unicorn_00;

import java.math.BigDecimal;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Create an admin
        Admin admin = new Admin(1, "admin", "admin123", "admin@example.com", 1001);

        // Admin login
        admin.login();

        // Admin adds a product
        admin.addProduct(new Product(101, "Laptop", BigDecimal.valueOf(999.99), "High-performance laptop", 10, "laptop.jpg"));

        // Admin generates sales report
        admin.generateSalesReport();

        // Admin logout
        admin.logout();

        // Create a customer
        Customer customer = new Customer(2, "customer", "customer123", "customer@example.com");

        // Customer login
        customer.login();

        // Customer adds products to cart
        customer.addToCart(new Product(201, "Smartphone", BigDecimal.valueOf(599.99), "Flagship smartphone", 1, "smartphone.jpg"));
        customer.addToCart(new Product(202, "Tablet", BigDecimal.valueOf(399.99), "Portable tablet", 2, "tablet.jpg"));

        // Customer places order
        customer.placeOrder();

        // Customer logout
        customer.logout();
    }
}


