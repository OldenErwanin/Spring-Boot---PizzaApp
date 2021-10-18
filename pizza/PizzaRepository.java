package com.example.pizzaapplication.pizza;

import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {
}
