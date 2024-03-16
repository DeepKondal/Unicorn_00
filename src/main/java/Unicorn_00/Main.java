package Unicorn_00;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Authentication authentication = new Authentication();

        authentication.loginUser("user1", "password1");

        // Create products
        Product product1 = new Product(1, "tv", 100.0, "tv", 20, "tv.jpg");
        Product product2 = new Product(2, "phone", 200.0, "phone", 20, "phone.jpg");

        // Create a customer
        Customer customer = new Customer(1, "user1", "password1", "john.doe@example.com", true);

        ShoppingCart cart = customer.getCart();

        // Add products to the customer's cart
        customer.addToCart(product1, 2); // Adding 2 units of Product 1
        customer.addToCart(product2, 1); // Adding 1 unit of Product 2
        System.out.println("Products in cart : ");
        cart.getCartItems().forEach(item ->
                System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity()));

        // Place the order
        Order order = customer.placeOrder();

        if (order != null) {
            // View the order details
            //System.out.println("Order ID: " + order.getOrderID());
            //System.out.println("Order Date: " + order.getOrderDate());
            //System.out.println("Order Status: " + (order.getStatus() ? "Completed" : "Pending"));
            //System.out.println("Order Amount Before Discount: $" + order.getOrderAmount());
            //System.out.println("Tax Amount: $" + (order.getOrderAmount() * 0.015)); // Assuming 1.5% tax
            //System.out.println("Order Amount After Discount and Tax: $" + order.getOrderAmount());
            //System.out.println("Applied Discount: " + (order.getAppliedDiscount() != null ? order.getAppliedDiscount().getCouponName() : "No discount applied"));

            // View the shipment details
            Shipment shipment = order.getShipment();
            if (shipment != null) {
                System.out.println("Shipment ID: " + shipment.getShipmentID());
                System.out.println("Delivery Method: " + shipment.getDeliveryChoice().getDeliveryMethod());
                System.out.println("Delivery Cost: $" + shipment.getDeliveryChoice().getDeliveryCost());
            }
        }
    }
}




/*
public class Main {
    public static void main(String[] args) {
        // Create an instance of Authentication
        Authentication authentication = new Authentication();
        Guest guest = new Guest(authentication);

        ShoppingCart cart = guest.getCart();

        // Add products to the cart as a Guest
        guest.addToCart(new Product(1, "tv", 100.0, "tv", 20, "tv.jpg"), 1);
        guest.addToCart(new Product(2, "phone", 200.0, "phone", 20, "phone.jpg"), 2);

        // Debugging: Print the current cart contents
        System.out.println("Cart contents after adding products:");
        cart.getCartItems().forEach(item ->
                System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity()));

        // Try to checkout as a Guest (should fail)
        cart.checkout();
        // Register a new regular user from guest
        guest.registerAsCustomer("testuser", "testpassword", "test@example.com");

        // Attempt to log in the registered user with correct credentials
        authentication.loginUser("testuser", "testpassword");

        // Log out the currently logged-in user
        authentication.logout();

        System.out.println("Registered Users:");
        for (User user : authentication.getRegisteredUsers()) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("User Type: " + user.getUserType());
            System.out.println("User ID: " + user.getUserID());

        }


    }
}
*/
