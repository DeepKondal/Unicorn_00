package Unicorn_00;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;


public class ShoppingCartTest {
    
    private ShoppingCart shoppingCart = new ShoppingCart();

    @Test
    public void testaddProduct() {
        
        assertEquals(shoppingCart.getCartItems().size(), 0);
        Product product = mock(Product.class);
        shoppingCart.addProduct(product, 1);
        //now cart size is 1.
        assertEquals(shoppingCart.getCartItems().size(), 1);
    }

    @Test
    public void testremoveProduct() {
        //mock a product
        Product product = mock(Product.class);
        when(product.getProductID()).thenReturn(1);
        shoppingCart.addProduct(product, 1);
        //add the product test.
        assertEquals(shoppingCart.getCartItems().size(),1);
        
        shoppingCart.removeProduct(1);
        //cart size reduced to 0 after removal.
        assertEquals(shoppingCart.getCartItems().size(), 0);
    }
    
    @Test
    public void testclearCart() {
        shoppingCart.clearCart();
        assertEquals(shoppingCart.getCartItems().size(),0);
    }
    @Test
    public void testisEmpty() {
        assertTrue(shoppingCart.isEmpty());
    }
    @Test
    public void testcheckout() {
        assertTrue(shoppingCart.checkout() instanceof Order);
    }

    @Test
    public void testcalculateTotal() {
        
        shoppingCart.addProduct(new Product(101, "Test Product", 99.99, "Test Description", 10, "test.jpg"), 1);
        shoppingCart.addProduct(new Product(102, "Test Product1", 9.99, "Test Description", 10, "test.jpg"), 5);

        shoppingCart.calculateTotal();
        assertTrue(shoppingCart.getTotalAmount() == 149.94);
    }
}
