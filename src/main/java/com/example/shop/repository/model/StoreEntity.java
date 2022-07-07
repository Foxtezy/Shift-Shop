package com.example.shop.repository.model;

import javax.persistence.*;
import java.awt.geom.Point2D;

@Entity
@Table(name = "store")
public class StoreEntity {
    @Id
    @Column(name = "store_name", nullable = false)
    private String store;

    @Column(name = "description")
    private String description;


    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
