package com.example.shop.repository.model;

import javax.persistence.*;
import java.awt.*;
import java.awt.geom.Point2D;

@Entity
@Table(name = "Buyers")
public class BuyerEntity {

    @Id
    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "balance", nullable = false)
    private Double balance;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
