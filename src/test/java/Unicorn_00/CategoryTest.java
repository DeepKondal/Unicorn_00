package Unicorn_00;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void testAddProduct() {
        Category category = new Category();
        Product product = new Product(1, "Test Product", 10.00, "Test Description", 5, "test.jpg");
        category.addProduct(product);
        assertTrue(category.getProducts().contains(product));
    }

    @Test
    public void testRemoveProduct() {
        Category category = new Category();
        Product product = new Product(1, "Test Product", 10.00, "Test Description", 5, "test.jpg");
        category.addProduct(product);
        category.removeProduct(product);
        assertFalse(category.getProducts().contains(product));
    }
}
