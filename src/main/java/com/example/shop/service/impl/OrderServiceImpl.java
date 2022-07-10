package com.example.shop.service.impl;

import com.example.shop.model.OrderInDto;
import com.example.shop.model.OrderOutDto;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.OrderService;
import com.example.shop.service.mapper.OrderInMapper;
import com.example.shop.service.mapper.OrderOutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderOutMapper orderOutMapper;

    private final OrderInMapper orderInMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderOutMapper orderOutMapper, OrderInMapper orderInMapper) {
        this.orderRepository = orderRepository;
        this.orderOutMapper = orderOutMapper;
        this.orderInMapper = orderInMapper;
    }

    public List<OrderOutDto> getOrders(String email){
        return orderRepository.getOrderEntitiesByBuyerEmailOrderByOrderId(email).stream().map(orderOutMapper::mapToOrderOutDto).collect(Collectors.toList());
    }

    public OrderOutDto saveOrderEntity(OrderInDto orderInDto){
        return orderOutMapper.mapToOrderOutDto(orderRepository.save(orderInMapper.mapToOrderEntity(orderInDto)));
    }



}
