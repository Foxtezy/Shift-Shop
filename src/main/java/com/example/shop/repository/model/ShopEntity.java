package com.example.shop.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "shop")
@Getter @Setter
public class ShopEntity {
    @Id
    @GeneratedValue
    @Column(name = "prod_id", nullable = false)
    private Long prodId;

    @Column(name = "ware", nullable = false)
    private String ware;

    @Column(name = "store", nullable = false)
    private String store;

    @Column(name = "amount", nullable = false)
    private Integer amount;

}
