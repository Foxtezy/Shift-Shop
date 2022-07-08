package com.example.shop.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
public class BuyerEntity {

    @Id
    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "balance", nullable = false)
    private Double balance;


    public BuyerEntity() {
    }

    public BuyerEntity(String login, String address, Double balance) {
        this.login = login;
        this.address = address;
        this.balance = balance;
    }

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
