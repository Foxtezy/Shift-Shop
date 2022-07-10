package com.example.shop.repository.model;


import ch.qos.logback.classic.db.names.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
@Getter @Setter @NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "product", nullable = false)
    private String product;

    public CategoryEntity(String category, String product) {
        this.category = category;
        this.product = product;
    }
}
