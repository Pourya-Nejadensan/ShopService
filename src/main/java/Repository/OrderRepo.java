package Repository;

import Model.Order;

import java.util.List;

public interface OrderRepo {
    List<Order> getOrders();

    void addOrderList(List<Order> orders);

    void addOrder(Order order);

    void removeOrderList(List<Order> orders);

    void removeOrder(Order order);

    Order findOrderById(int id);
}
