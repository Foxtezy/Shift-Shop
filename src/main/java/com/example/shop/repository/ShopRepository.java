package com.example.shop.repository;

import com.example.shop.repository.model.ShopEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Integer>{
    List<ShopEntity> getShopEntityByWare(String ware);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ShopEntity e SET e.amount = ?1 where e.ware = ?2 and e.store = ?3")
    int updateAmount(Integer amount, String ware, String store);

}
