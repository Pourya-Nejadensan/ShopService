import Model.Product;
import Repository.Impl.OrderListRepo;
import Repository.Impl.OrderMapRepo;
import Repository.Impl.ProductRepo;
import Repository.OrderRepo;
import Service.ShopService;

import java.util.Scanner;

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

        // Scanner
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. List Products");
            System.out.println("4. Place Order");
            System.out.println("5. Modify Order");
            System.out.println("6. List Orders");
            System.out.println("7. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Enter Product Price: ");
                    double productPrice = scanner.nextDouble();

                    System.out.print("Enter Product Quantity: ");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Product Description: ");
                    String productDescription = scanner.nextLine();

                    productRepo.addProduct(new Product( productId, productName, productPrice, productQuantity, productDescription));
                    break;

                case 2:
                    System.out.print("Enter Product ID to Remove: ");
                    int removeProductId = scanner.nextInt();
                    productRepo.removeProductById(removeProductId);
                    break;

                case 3:
                    for (Product product : productRepo.getProductList()) {
                        System.out.println(product);
                    }
                    break;

                case 4:
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();

                    System.out.print("Enter Product ID: ");
                    int orderProductId = scanner.nextInt();

                    System.out.print("Enter Quantity: ");
                    int orderQuantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Product Name: ");
                    String orderProductName = scanner.nextLine();

                    shopService.placeOrder(orderId, orderProductId, orderQuantity, orderProductName);
                    break;

 /*               case 5:
                    System.out.print("Enter Order ID to Modify: ");
                    int modifyOrderId = scanner.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();

                    shopService.modifyOrder(modifyOrderId, newQuantity);
                    break;*/

                case 6:
                    orderRepo.getOrders().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}