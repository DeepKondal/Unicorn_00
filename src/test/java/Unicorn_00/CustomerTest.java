package Unicorn_00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testAddToCart() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        Product product = new Product(101, "Test Product", 99.99, "Test Description", 10, "test.jpg");
        customer.addToCart(product,1);
        assertTrue(customer.getCart().getCartItems().size() == 1); // If addToCart method executes without errors, the test passes
    }

    @Test
    public void testRemoveFromCart() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        Product product = new Product(101, "Test Product", 99.99, "Test Description", 10, "test.jpg");
        customer.addToCart(product,1);
        customer.removeFromCart(product);
        assertTrue(customer.getCart().isEmpty()); // If removeFromCart method executes without errors, the test passes
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

    @Test
    public void testplaceOrder() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        Product product = new Product(101, "Test Product", 99.99, "Test Description", 10, "test.jpg");
        customer.addToCart(product,1);
        
        Order order = customer.placeOrder();
        assertNotNull(order);
        //order gets generated; status set to true.
        assertTrue(order.getStatus());
        //cart is done empty after order is placed.
        assertTrue(customer.getCart().isEmpty());
        //empty cart order not created.
        assertNull(customer.placeOrder());
    }

    @Test
    public void testcancelOrder() {
        Customer customer = new Customer(1, "customer1", "customerpass", "customer1@example.com",true);
        Product product = new Product(101, "Test Product", 99.99, "Test Description", 10, "test.jpg");
        customer.addToCart(product,1);
        
        Order order = customer.placeOrder();
        //orders list has one object.
        assertEquals(customer.getOrders().size(),1);
        //cancel order placed.
        customer.cancelOrder(order.getOrderID());
        //order list size becomes 0.
        assertEquals(customer.getOrders().size(),0);
    }
}