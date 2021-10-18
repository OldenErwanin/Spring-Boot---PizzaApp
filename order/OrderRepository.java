package com.example.pizzaapplication.order;

import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order, Integer> {
}
