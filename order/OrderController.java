package com.example.pizzaapplication.order;


import com.example.pizzaapplication.pizza.PizzaService;
import com.example.pizzaapplication.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping("/orders")
    public String getAllOrders() {
        List<Order> listOfOrder = orderService.getAllOrders();
        String returnedString = "";
        for (Order order : listOfOrder) {
            returnedString += order.toString() + "\n------------------------\n";
        }
        return returnedString;
    }

    @RequestMapping("/orders/{id}")
    public String getOrder(@PathVariable int id) {
        return orderService.getOrder(id).toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public String createOrder(@RequestBody Order order) {
        if ((userService.findUserById(order.getUser_id()) != null) && (pizzaService.findPizzaById(order.getPizza_id()) != null)) {
            return orderService.createOrder(order);
        } else {
            System.out.println("Invalid user or pizza!");
            return "Invalid user or pizza!";
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody Order order) {
        if ((userService.findUserById(order.getUser_id()) != null) && (pizzaService.findPizzaById(order.getPizza_id()) != null)) {
            return orderService.updateOrder(id, order);
        } else {
            System.out.println("Invalid user or pizza!");
            return "Invalid user or pizza!";
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
    public String deleteOrder(@PathVariable int id) {
        return orderService.deleteOrder(id);
    }
}
