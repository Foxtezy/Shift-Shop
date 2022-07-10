package com.example.shop.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Stores")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StoreEntity {
    @Id
    @Column(name = "store_name", nullable = false)
    private String store;

    @Column(name = "address", nullable = false)
    private String address;
}
