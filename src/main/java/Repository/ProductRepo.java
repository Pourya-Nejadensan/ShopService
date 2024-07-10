package Repository;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> productList;

    public ProductRepo() {
        productList = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addProductList(List<Product> products) {
        productList.addAll(products);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public void removeProductById(int id) {
        productList.removeIf(product -> product.id() == id);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product findProductById(int id) {
        return productList.stream().filter(product -> product.id() == id).findFirst().orElse(null);
    }
}
