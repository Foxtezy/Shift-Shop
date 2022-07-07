package com.example.shop.model;

public class Buyer {
    private String name;
    private String address;
    private Double balance;

    Buyer(String name, String address, Double balance){
        this.name = name;
        this.address = address;
        this.balance = balance;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public Double getBalance() { return balance; }

    public void setBalance(Double balance) { this.balance = balance; }


}
