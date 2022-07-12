package com.example.shop.repository;

import com.example.shop.repository.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE ProductEntity e SET e.description = ?2 where e.ware = ?1")
    Integer editProductDescription(String ware, String description);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ProductEntity e SET e.price = ?2 where e.ware = ?1")
    Integer editProductPrice(String ware, Double price);

}
