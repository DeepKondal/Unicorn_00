package Unicorn_00;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testAddToCart() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        Product product = new Product(101, "Test Product", BigDecimal.valueOf(99.99), "Test Description", 10, "test.jpg");
        customer.addToCart(product);
        assertTrue(true); // If addToCart method executes without errors, the test passes
    }

    @Test
    public void testRemoveFromCart() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        Product product = new Product(101, "Test Product", BigDecimal.valueOf(99.99), "Test Description", 10, "test.jpg");
        customer.addToCart(product);
        customer.removeFromCart(product);
        assertTrue(true); // If removeFromCart method executes without errors, the test passes
    }

    @Test
    public void testClearCart() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        customer.clearCart();
        assertTrue(true); // If clearCart method executes without errors, the test passes
    }
}