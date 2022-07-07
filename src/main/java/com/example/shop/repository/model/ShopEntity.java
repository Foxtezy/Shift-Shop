package com.example.shop.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class ShopEntity { //надо назвать адекватно
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

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
