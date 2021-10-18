package com.example.pizzaapplication.user;

import com.example.pizzaapplication.pizza.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<>();
        userRepository.findAll().forEach(listUser::add);
        return listUser;
    }

    public User findUserById(int id) {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("Failed to find user: " + e.getMessage());
            return null;
        }
    }

    public String createUser(User user) {
        try {
            userRepository.save(user);
            return "Created user:\n" + user.toString();
        } catch (Exception e) {
            System.out.println("Failed to create user: " + e.getMessage());
            return "Failed to create user: " + e.getMessage();
        }
    }

    public String updateUser(int id, User user) {
        try {
            User updatedUser = userRepository.findById(id).get();
            updatedUser.setEmail(user.getEmail());
            updatedUser.setAddress(user.getAddress());
            userRepository.save(updatedUser);
            return "Updated user on ID: " + id;
        } catch (Exception e) {
            System.out.println("Failed to update user: " + e.getMessage());
            return "Failed to update user: " + e.getMessage();
        }
    }

    public String deleteUser(int id) {
        try {
            userRepository.delete(userRepository.findById(id).get());
            return "Deleted user on ID: " + id;
        } catch (Exception e) {
            return "Failed to delete user: " + e.getMessage();
        }
    }
}
