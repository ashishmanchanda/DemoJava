package designpatternpracticeshrayansh.facade;

// Complex Subsytems

// Subsystem A: Inventory
 class InventoryService {
    public boolean checkStock(String productId) {
        System.out.println("Checking stock for product: " +
                productId);
        return true; // assume it's always in stock
    }
}
// Subsystem B: Payment
 class PaymentService {
    public boolean makePayment(String paymentMethod) {
        System.out.println("Processing payment using: " +
                paymentMethod);
        return true; // assume payment always succeeds
    }
}
// Subsystem C: Shipping
 class ShippingService {
    public void shipProduct(String productId) {
        System.out.println("Shipping product: " + productId);
    }
}
// Subsystem D: Notification
 class NotificationService {
    public void sendConfirmation(String productId) {
        System.out.println("Sending order confirmation for product: "
                + productId);
    }
}

 class OrderFacade {
    private final InventoryService inventory;
    private final PaymentService payment;
    private final ShippingService shipping;
    private final NotificationService notification;

    public OrderFacade() {
        this.inventory = new InventoryService();
        this.payment = new PaymentService();
        this.shipping = new ShippingService();
        this.notification = new NotificationService();
    }

    // Simplified method for clients
    public void placeOrder(String productId, String paymentMethod) {

        // The following steps are hidden from the client and need tobe executed in a specific order
        System.out.println("Placing order for product: " + productId);

        // Step : Check stock
        if (!inventory.checkStock(productId)) {
            System.out.println("Product out of stock!");
            return;
        }

        // Step : Make payment
        if (!payment.makePayment(paymentMethod)) {
            System.out.println("Payment failed!");
            return;
        }

        // Step : Ship product
        shipping.shipProduct(productId);

        // Step : Send confirmation
        notification.sendConfirmation(productId);

        System.out.println("Order placed successfully!");
    }
}
 class ECommerceApp {
    public static void main(String[] args) {
        System.out.println("====== Facade Design Pattern Demo ======");
                // Client interacts with a simple Facade, not with allsubsystems.
                        OrderFacade orderFacade = new OrderFacade();

        // Place order with one call to Facade
        orderFacade.placeOrder("MacBook Pro", "Credit Card");

        // Place another order with one call to Facade
        orderFacade.placeOrder("Cricket Bat", "UPI");
    }
}