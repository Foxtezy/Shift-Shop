package com.example.shop.repository.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "buyers")
@Getter @Setter @NoArgsConstructor
public class BuyerEntity {
    @Id
    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "balance", nullable = false)
    private Double balance;

    public BuyerEntity(String login, String address, Double balance) {
        this.login = login;
        this.address = address;
        this.balance = balance;
    }
}
