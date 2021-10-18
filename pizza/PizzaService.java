package com.example.pizzaapplication.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizza() {
        List<Pizza> listPizza = new ArrayList<>();
        pizzaRepository.findAll().forEach(listPizza::add);
        return listPizza;
    }

    public Pizza findPizzaById(int id) {
        try {
            return pizzaRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("Failed to find pizza: " + e.getMessage());
            return null;
        }
    }

    public String createPizza(Pizza pizza) {
        try {
            pizzaRepository.save(pizza);
            return "Created pizza:\n" + pizza.toString();
        } catch (Exception e) {
            System.out.println("Failed to create pizza: " + e.getMessage());
            return "Failed to create pizza: " + e.getMessage();
        }
    }

    public String updatePizza(int id, Pizza pizza) {
        try {
            Pizza updatedPizza = pizzaRepository.findById(id).get();
            updatedPizza.setType(pizza.getType());
            pizzaRepository.save(updatedPizza);
            return "Updated pizza on ID: " + id;
        } catch (Exception e) {
            System.out.println("Failed to update pizza: " + e.getMessage());
            return "Failed to update pizza: " + e.getMessage();
        }
    }

    public String deletePizza(int id) {
        try {
            pizzaRepository.delete(pizzaRepository.findById(id).get());
            return "Deleted pizza on ID: " + id;
        } catch (Exception e) {
            return "Failed to delete pizza: " + e.getMessage();
        }
    }
}
