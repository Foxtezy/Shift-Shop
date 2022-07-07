package com.example.shop.repository;

import com.example.shop.repository.model.StoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<StoreEntity, String> {

}
