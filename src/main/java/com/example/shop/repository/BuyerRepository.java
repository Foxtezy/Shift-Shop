package com.example.shop.repository;


import com.example.shop.repository.model.BuyerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BuyerRepository extends CrudRepository<BuyerEntity, String> {
    Optional<BuyerEntity> findBylogin(String login);

    //List<BuyerEntity> findFirst5ByFirstNameStartsWithOrderByFirstName(String firstNameStartsWith);
}
