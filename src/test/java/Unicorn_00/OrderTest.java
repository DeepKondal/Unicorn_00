package Unicorn_00;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderTest {

    List<CartItem> cart = new ArrayList<>();

    @Before
    public void setUp() {
        
        CartItem cartItem1 = mock(CartItem.class);
        CartItem cartItem2 = mock(CartItem.class);
        cart.add(cartItem1);
        cart.add(cartItem2);
    }
    
    @Test
    public void testplaceOrder() {

        Order order = new Order(cart,100.00);
        assertTrue(order.getOrderID() instanceof UUID);
    }
}
