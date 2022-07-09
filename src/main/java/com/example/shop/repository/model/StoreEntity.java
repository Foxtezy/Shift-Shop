package com.example.shop.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "store")
@Getter @Setter
public class StoreEntity {
    @Id
    @Column(name = "store_name", nullable = false)
    private String store;

    @Column(name = "description")
    private String description;
}
