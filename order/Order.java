package com.example.pizzaapplication.order;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "orders")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private int user_id;
    @NotNull
    private int pizza_id;


    public Order() {
    }

    public Order(int user_id, int pizza_id) {
        this.user_id = user_id;
        this.pizza_id = pizza_id;
    }

    public Order(int id, int user_id, int pizza_id) {
        this.id = id;
        this.user_id = user_id;
        this.pizza_id = pizza_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }



    public int getUser_id() {
        return user_id;
    }

    public int getPizza_id() {
        return pizza_id;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\nUserID: " + this.user_id + "\nPizzaID: " + this.pizza_id;
    }
}
