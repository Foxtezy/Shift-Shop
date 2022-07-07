package com.example.shop.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
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

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getWare() {
        return ware;
    }

    public void setWare(String ware) {
        this.ware = ware;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
