package Unicorn_00;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testUpdateStock() {
        Product product = new Product(1, "Test Product", 10.00, "Test Description", 5, "test.jpg");
        product.updateStock(3);
        assertEquals(8, product.getStockQuantity());
    }

    @Test
    public void testAddCategory() {
        Product product = new Product(1, "Test Product", 10.00, "Test Description", 5, "test.jpg");
        Category category = new Category();
        product.addCategory(category);
        assertTrue(product.getCategories().contains(category));
    }

    @Test
    public void testRemoveCategory() {
        Product product = new Product(1, "Test Product", 10.00, "Test Description", 5, "test.jpg");
        Category category = new Category();
        product.addCategory(category);
        product.removeCategory(category);
        assertFalse(product.getCategories().contains(category));
    }
}
