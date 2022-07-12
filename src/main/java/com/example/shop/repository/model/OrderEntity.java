package com.example.shop.repository.model;


import com.example.shop.repository._enum_.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
@Getter @Setter @NoArgsConstructor
public class OrderEntity{
    @Id
    @GeneratedValue
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "ware", nullable = false)
    private String ware;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "store", nullable = false)
    private String store;
    @Column(name = "order_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "buyer_email", nullable = false)
    private String buyerEmail;

    public OrderEntity(String ware, Double price, Integer amount, OrderStatus orderStatus, String buyerEmail, String store) {
        this.ware = ware;
        this.price = price;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.buyerEmail = buyerEmail;
        this.store = store;
    }
}


