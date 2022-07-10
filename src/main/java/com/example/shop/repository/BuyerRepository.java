package com.example.shop.repository;


import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.repository.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BuyerRepository extends CrudRepository<BuyerEntity, String>{

    @Modifying
    @Transactional
    @Query(value = "UPDATE BuyerEntity e SET e.balance = ?2 where e.email = ?1")
    Integer updateBalance(String email, Double balance);



}
