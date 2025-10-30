package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private int id;

    private String name;
    private double balance;

    public Account() {}
    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() { return id; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
