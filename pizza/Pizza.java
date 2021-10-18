package com.example.pizzaapplication.pizza;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "pizza")
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String type;

    public Pizza() {
    }
    public Pizza(String type) {
        this.type = type;
    }

    public Pizza(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\nType: " + this.type;
    }
}
