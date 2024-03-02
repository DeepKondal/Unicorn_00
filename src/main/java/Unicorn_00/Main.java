package Unicorn_00;


public class Main {

    public static void main(String[] args) {
        // Create an instance of Authentication
        Authentication authentication = new Authentication();

        // Create instances of Login, Logout, and Registration
        Login login = new Login(authentication);
        Logout logout = new Logout();
        Registration registration = new Registration(authentication);

        // Register a user
        registration.registerUser("user1", "password1", "user1@example.com");

        // Attempt to log in with correct credentials
        login.loginUser("user1", "password1");
        Customer customer = new Customer(1, "user1", "password1", "user1@example.com",login.isLoggedIn());
        System.out.println("User name is : " +customer.getUsername());
                
        // Customer adds products to cart
        customer.addToCart(new Product(201, "Smartphone", 599.99, "Flagship smartphone", 1, "smartphone.jpg"),1);
        customer.addToCart(new Product(202, "Tablet", 399.99, "Portable tablet", 2, "tablet.jpg"),2);



        // Customer places order
        customer.placeOrder();

        //customer.cancelOrder(order.getOrderID());
        
        // Customer adds products to cart
        customer.addToCart(new Product(101, "Soap", 9.99, "Flagship soap", 6, "soap.jpg"),6);
        customer.addToCart(new Product(102, "Toy", 99.99, "Portable toy", 7, "toy.jpg"),7);

        // Customer places order
        customer.placeOrder();
        
        //show active orders
        for(Order currentOrder : customer.getOrders()){
            System.out.println("Order ID: "+currentOrder.getOrderID()+" - Payment ID: "+currentOrder.getPaymentID());
        }
        // Log out the user
        logout.logoutUser(login);
        // Attempt to log in with incorrect credentials
        login.loginUser("user1", "wrongpassword");
    }
}

