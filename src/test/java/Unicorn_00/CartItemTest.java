package Unicorn_00;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class CartItemTest {
    
    Product product = mock(Product.class);
    

    @Test
    public void testupdateQuantity() {
        CartItem cartItem = new CartItem(product, 10);
        cartItem.updateQuantity(20);
        assertEquals(cartItem.getQuantity(),20);
    }

    @Test
    public void testcalculateSubtotal() {
        CartItem cartItem = new CartItem(product, 10);
        when(product.getPrice()).thenReturn(9.99);
        cartItem.calculateSubTotal();
        assertTrue(cartItem.getSubTotal() == 99.90);
    }
}
