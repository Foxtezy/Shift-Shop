package com.example.shop.repository;


import com.example.shop.repository.model.BuyerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends CrudRepository<BuyerEntity, String>{


}
