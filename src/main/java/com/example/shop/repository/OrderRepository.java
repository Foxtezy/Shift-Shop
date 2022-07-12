package com.example.shop.repository;

import com.example.shop.repository._enum_.OrderStatus;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.repository.model.OrderEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    List<OrderEntity> getOrderEntitiesByBuyerEmailOrderByOrderId(String email);

    @Query(value = "SELECT e FROM OrderEntity e WHERE e.store = ?1 AND e.orderStatus = 'REGISTRATION'")
    List<OrderEntity> getNotShippedWares(String store);

    @Modifying
    @Transactional
    @Query(value = "UPDATE OrderEntity e SET e.orderStatus = ?2 where e.orderId = ?1")
    Integer updateOrderStatus(Long orderId, OrderStatus orderStatus);

}
