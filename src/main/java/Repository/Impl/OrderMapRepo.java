package Repository.Impl;

import Model.Order;
import Repository.OrderRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
    private Map<Integer, Order> orders;

    public OrderMapRepo() {
        this.orders = new HashMap<>();
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void addOrderList(List<Order> orders) {
        for (Order order : orders) {
            this.orders.put(order.id(), order);
        }
    }

    @Override
    public void addOrder(Order order) {
        this.orders.put(order.id(), order);
    }

    @Override
    public void removeOrderList(List<Order> orders) {
        for (Order order : orders) {
            this.orders.remove(order.id());
        }
    }

    @Override
    public void removeOrder(Order order) {
        this.orders.remove(order.id());
    }

    @Override
    public Order findOrderById(int id) {
        return this.orders.get(id);
    }
}
