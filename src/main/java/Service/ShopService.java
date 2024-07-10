package Service;

import Model.Order;
import Model.Product;
import Repository.Impl.OrderListRepo;
import Repository.Impl.ProductRepo;

import java.time.LocalDate;


public class ShopService {
    private ProductRepo productRepo;
    private OrderListRepo orderListRepo;

    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    public void placeOrder(int orderId, int productId, int quantity, String productName) {
        Product product = productRepo.findProductById(productId);

        if (product == null) {
            System.out.println("Product " + productName + " does not exist.");
            return;
        }

        if (product.quantity() < quantity) {
            System.out.println("Insufficient quantity for product " + productName + " .");
            return;
        }

        // Create a new order
        Order order = new Order(orderId, product,quantity, LocalDate.now());
        orderListRepo.addOrder(order);

        // Update product quantity


        System.out.println("Order placed successfully: " + order);
    }
}
