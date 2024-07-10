package Repository.Impl;

import Model.Order;
import Repository.OrderRepo;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo {
    private List<Order> orderList;

    public OrderListRepo() {
        orderList = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orderList;
    }

    public void addOrderList(List<Order> orders) {
        this.orderList.addAll(orders);
    }

    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    public void removeOrderList(List<Order> orders) {
        this.orderList.removeAll(orders);
    }

    public void removeOrder(Order order) {
        this.orderList.remove(order);
    }

    public Order findOrderById(int id) {
        return orderList.stream().filter(order -> order.id() == id).findFirst().orElse(null);
    }
}