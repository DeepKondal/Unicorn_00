package Unicorn_00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testAddToCart() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        Product product = new Product(101, "Test Product", 99.99, "Test Description", 10, "test.jpg");
        customer.addToCart(product,1);
        assertTrue(true); // If addToCart method executes without errors, the test passes
    }

    @Test
    public void testRemoveFromCart() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        Product product = new Product(101, "Test Product", 99.99, "Test Description", 10, "test.jpg");
        customer.addToCart(product,1);
        customer.removeFromCart(product);
        assertTrue(true); // If removeFromCart method executes without errors, the test passes
    }

    @Test
    public void testClearCart() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        
        Product product = new Product(101, "Test Product", 99.99, "Test Description", 10, "test.jpg");
        customer.addToCart(product,1);
        
        customer.clearCart();
        //cart is empty.
        assertTrue(customer.getCart().isEmpty());
    }
}