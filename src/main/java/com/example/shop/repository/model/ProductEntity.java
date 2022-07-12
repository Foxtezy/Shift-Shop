package com.example.shop.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Products")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "ware_name", nullable = false)
    private String ware;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description", nullable = true)
    private String description;
}
