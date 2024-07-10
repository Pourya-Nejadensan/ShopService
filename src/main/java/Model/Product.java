package Model;

public record Product(
        int id,
        String name,
        double price,
        int quantity,
        String description
) {
}
