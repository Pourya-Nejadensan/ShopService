package Repository;

import Model.Product;

import java.util.List;

public class ProductRepo {
    private List<Product> productList;

    public void addProduct(Product product) {
        productList.add(product);
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

    public Product getProductById(int id) {
        return productList.stream().filter(product -> product.id() == id).findFirst().orElse(null);
    }
}
