package com.example.shop.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter @Setter
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "prod_id", nullable = false)
    private Long prodId;

    @Column(name = "ware", nullable = false)
    private String ware;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "price", nullable = false)
    private Double price;

}
