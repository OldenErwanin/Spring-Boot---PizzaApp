package com.example.pizzaapplication.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping("/pizza")
    public String getAllPizza() {
        List<Pizza> listOfPizza = pizzaService.getAllPizza();
        String returnedString = "";
        for (Pizza pizza : listOfPizza) {
            returnedString += pizza.toString() + "\n------------------------\n";
        }
        return returnedString;
    }

    @RequestMapping("/pizza/{id}")
    public String getPizza(@PathVariable int id) {
        return pizzaService.findPizzaById(id).toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pizza")
    public String createPizza(@RequestBody Pizza pizza) {
        return pizzaService.createPizza(pizza);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pizza/{id}")
    public void updatePizza(@PathVariable int id, @RequestBody Pizza pizza) {
        pizzaService.updatePizza(id, pizza);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/pizza/{id}")
    public String deletePizza(@PathVariable int id) {
        return pizzaService.deletePizza(id);
    }
}
