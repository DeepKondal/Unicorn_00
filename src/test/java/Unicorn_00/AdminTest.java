package Unicorn_00;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    @Test
    public void testAddProduct() {

        Admin admin = new Admin(1, "admin1", "adminpass", "admin1@example.com", 1001,null);
        Product product = new Product(101, "Test Product", BigDecimal.valueOf(99.99), "Test Description", 10, "test.jpg");
        admin.addProduct(product);
        assertTrue(true); // If addProduct method executes without errors, the test passes
    }

    @Test
    public void testRemoveProduct() {
        Admin admin = new Admin(1, "admin1", "adminpass", "admin1@example.com", 1001,null);
        admin.removeProduct(101);
        assertTrue(true); // If removeProduct method executes without errors, the test passes
    }

    @Test
    public void testUpdateProduct() {
        Admin admin = new Admin(1, "admin1", "adminpass", "admin1@example.com", 1001,null);
        Product updatedProduct = new Product(101, "Updated Product", BigDecimal.valueOf(199.99), "Updated Description", 20, "updated.jpg");
        admin.updateProduct(101, updatedProduct);
        assertTrue(true); // If updateProduct method executes without errors, the test passes
    }
}