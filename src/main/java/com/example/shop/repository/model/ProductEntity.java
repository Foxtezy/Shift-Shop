package com.example.shop.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Products")
@Getter @Setter @NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "prod_id", nullable = false)
    private Long prodId;

    @Column(name = "ware", nullable = false)
    private String ware;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "store_name", nullable = false)
    private String store;

    public ProductEntity(String ware, Double price, Integer amount, String description, String store) {
        this.ware = ware;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.store = store;
    }
}
