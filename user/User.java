package com.example.pizzaapplication.user;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name="email_address")
    private String email;
    @NotNull
    private String address;

    public User() {}

    public User(String email, String address) {
        this.email = email;
        this.address = address;
    }

    public User(Integer id, String email, String address) {
        this.id = id;
        this.email = email;
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\nEmail: " + this.email + "\nAddress: " + this.address;
    }

}
