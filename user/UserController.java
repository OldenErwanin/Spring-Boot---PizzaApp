package com.example.pizzaapplication.user;

import com.example.pizzaapplication.pizza.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public String getAllUser() {
        List<User> listOfUser = userService.getAllUser();
        String returnedString = "";
        for (User user : listOfUser) {
            returnedString += user.toString() + "\n------------------------\n";
        }
        return returnedString;
    }

    @RequestMapping("/users/{id}")
    public String getUser(@PathVariable int id) {
        return userService.findUserById(id).toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }


}
