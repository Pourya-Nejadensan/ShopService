package Service;

import Model.Order;
import Model.Product;
import Repository.Impl.OrderListRepo;
import Repository.Impl.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ShopServiceTest {
    private ShopService shopService;
    private ProductRepo productRepo;
    private OrderListRepo orderListRepo;

    @BeforeEach
    public void setUp() {
        this.productRepo = new ProductRepo();
        this.orderListRepo = new OrderListRepo();
        this.shopService = new ShopService(productRepo, orderListRepo);
    }

    private void makeSimpleProductRepoData() {
        Product laptop = new Product(1, "Laptop", 999.99, 10,"High-performance laptop");
        Product phone = new Product( 2,"Phone", 599.99, 20, "Latest smartphone");
        productRepo.addProduct(laptop);
        productRepo.addProduct(phone);
    }

    private void makeSimpleOrderRepoData() {
        shopService.placeOrder(1, 1, 2, "Laptop");
        shopService.placeOrder(2, 2, 1, "Phone");
        shopService.placeOrder(3, 3, 1, "Tablet"); // This should print a message that the product does not exist
        shopService.placeOrder(4, 1, 20, "Laptop"); // This should print a message that the quantity is insufficient
    }

    @Test
    void placeOrderTest_whenFindExistOrderById_returnNotNull() {
        // GIVEN
        makeSimpleProductRepoData();
        makeSimpleOrderRepoData();

        // WHEN
        Order order = orderListRepo.findOrderById(1);

        // THEN
        assertThat(order).isNotNull();
    }

    @Test
    void placeOrderTest_whenQuantityOfProductIsEnoughForOrder_returnTrue() {
        // GIVEN
        makeSimpleProductRepoData();
        makeSimpleOrderRepoData();

        // WHEN
        Order order = orderListRepo.findOrderById(1);
        Product product = productRepo.findProductById(order.product().id());

        // THEN
        assertThat(order.quantity()).isLessThanOrEqualTo(product.quantity());
    }
}