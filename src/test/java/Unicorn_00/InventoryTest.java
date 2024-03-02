package Unicorn_00;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }
    @Test
    public void testAddProduct() {
        Product newProduct = new Product(104, "New Product", 25.99, "Description 4", 20, "image4.jpg");
        inventory.addProduct(newProduct);

        assertTrue(inventory.getProducts().contains(newProduct));
    }
    @Test
    public void testRemoveProduct() {
        int productIdToRemove = 101;
        inventory.removeProduct(productIdToRemove);

        boolean productFound = false;
        for (Product product : inventory.getProducts()) {
            if (product.getProductID() == productIdToRemove) {
                productFound = true;
                break;
            }
        }

        assertFalse(productFound);
    }
    @Test
    public void testUpdateProduct() {
        int productIdToUpdate = 102;
        Product updatedProduct = new Product(productIdToUpdate, "Updated Product", 30.99, "Updated Description", 25, "updated_image.jpg");
        inventory.updateProduct(productIdToUpdate, updatedProduct);

        for (Product product : inventory.getProducts()) {
            if (product.getProductID() == productIdToUpdate) {
                assertEquals(updatedProduct.getName(), product.getName());
                assertEquals(updatedProduct.getDescription(), product.getDescription());
                assertEquals(updatedProduct.getPrice(), product.getPrice());
                assertEquals(updatedProduct.getStockQuantity(), product.getStockQuantity());
                assertEquals(updatedProduct.getImage(), product.getImage());
                break;
            }
        }
    }
    @Test
    public void testCheckAvailability() {
        assertTrue(inventory.checkAvailability(103));
        assertFalse(inventory.checkAvailability(105));
    }
}
