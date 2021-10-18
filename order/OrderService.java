package com.example.pizzaapplication.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        List<Order> listOrders = new ArrayList<>();
        orderRepository.findAll().forEach(listOrders::add);
        return listOrders;
    }

    public Order getOrder(int id) {
        try {
            return orderRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("Failed to find order: " + e.getMessage());
            return null;
        }
    }

    public String createOrder(Order order) {
        try {
            orderRepository.save(order);
            return "Created order:\n" + order.toString();
        } catch (Exception e) {
            System.out.println("Failed to create order: " + e.getMessage());
            return "Failed to create order: " + e.getMessage();
        }
    }

    public String updateOrder(int id, Order order) {
        try {
            Order updatedOrder = orderRepository.findById(id).get();
            updatedOrder.setPizza_id(order.getPizza_id());
            updatedOrder.setUser_id(order.getUser_id());
            orderRepository.save(updatedOrder);
            return "Updated order on ID: " + id;
        } catch (Exception e) {
            System.out.println("Failed to update order: " + e.getMessage());
            return "Failed to update order: " + e.getMessage();
        }
    }

    public String deleteOrder(int id) {
        try {
            orderRepository.delete(orderRepository.findById(id).get());
            return "Deleted order on ID: " + id;
        } catch (Exception e) {
            System.out.println("Failed to delete order: " + e.getMessage());
            return "Failed to delete order: " + e.getMessage();
        }
    }
}
