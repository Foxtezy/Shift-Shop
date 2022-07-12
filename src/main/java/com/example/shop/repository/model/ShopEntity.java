package com.example.shop.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Shop")
@Getter @Setter @NoArgsConstructor
public class ShopEntity {

    @Id
    @GeneratedValue
    @Column(name = "prod_id", nullable = false)
    private Long prodId;

    @Column(name = "ware", nullable = false)
    private String ware;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "store_name", nullable = false)
    private String store;

    public ShopEntity(String ware, Integer amount, String store) {
        this.ware = ware;
        this.amount = amount;
        this.store = store;
    }
}
