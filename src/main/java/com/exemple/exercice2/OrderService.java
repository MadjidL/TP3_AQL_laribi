package com.exemple.exercice2;

public class OrderService {
    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order order) {
        // Validation, calculs, etc.
        orderDao.saveOrder(order);
    }
}