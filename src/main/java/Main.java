import Model.Product;
import Repository.Impl.OrderListRepo;
import Repository.Impl.OrderMapRepo;
import Repository.Impl.ProductRepo;
import Repository.OrderRepo;
import Service.ShopService;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories
        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo;

        // Choose implementation
        if (args.length > 0 && args[0].equals("map")){
            orderRepo = new OrderMapRepo();
        } else {
            orderRepo = new OrderListRepo();
        }

        // Initialize shop service
        ShopService shopService = new ShopService(productRepo, orderRepo);

        // Add products to the repository
        Product laptop = new Product(1, "Laptop", 999.99, 10,"High-performance laptop");
        Product phone = new Product( 2,"Phone", 599.99, 20, "Latest smartphone");
        productRepo.addProduct(laptop);
        productRepo.addProduct(phone);

        // Place orders
        shopService.placeOrder(1, 1, 2, "Laptop");
        shopService.placeOrder(2, 2, 1, "Phone");
        shopService.placeOrder(3, 3, 1, "Tablet"); // This should print a message that the product does not exist
        shopService.placeOrder(4, 1, 20, "Laptop"); // This should print a message that the quantity is insufficient
    }
}