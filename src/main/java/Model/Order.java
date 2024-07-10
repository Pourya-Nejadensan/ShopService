package Model;

import java.time.LocalDate;

public record Order(
        int id,
        Product product,
        int quantity,
        LocalDate orderDate
) {
    public double getTotalPrice(){
        return product.price() * quantity;
    }
}
