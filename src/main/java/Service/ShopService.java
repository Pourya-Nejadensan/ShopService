package Service;

import Model.Order;
import Model.Product;
import Repository.Impl.ProductRepo;
import Repository.OrderRepo;
import Util.CommandLineStyle;

import java.time.LocalDate;


public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(int orderId, int productId, int quantity, String productName) {
        Product product = productRepo.findProductById(productId);

        if (product == null) {
            System.out.println(CommandLineStyle.red("Product " + productName + " does not exist."));
            return;
        }

        if (product.quantity() < quantity) {
            System.out.println(CommandLineStyle.red("Insufficient quantity for product " + productName + " ."));
            return;
        }

        // Create a new order
        Order order = new Order(orderId, product,quantity, LocalDate.now());
        orderRepo.addOrder(order);

        // Update product quantity


        System.out.println(CommandLineStyle.green("Order placed successfully: " + order));
    }
}