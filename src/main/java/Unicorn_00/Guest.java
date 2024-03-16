package Unicorn_00;

public class Guest {
    private ShoppingCart cart;
    private Authentication authentication;

    public Guest(Authentication authentication) {
        this.cart = new ShoppingCart();
        this.authentication = authentication;
    }

    public void addToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }

    public void removeFromCart(Product product) {
        cart.removeProduct(product.getProductID());
    }

    public void registerAsCustomer(String username, String password, String email) {
        authentication.registerUser(username, password, email, false); // Pass true for isLoggedIn
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
