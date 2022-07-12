package com.example.shop.service.impl;

import com.example.shop.model.BuyDto;
import com.example.shop.model.OrderInDto;
import com.example.shop.model.OrderOutDto;
import com.example.shop.model.ShopDto;
import com.example.shop.repository.*;
import com.example.shop.repository._enum_.OrderStatus;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.repository.model.ProductEntity;
import com.example.shop.service.OrderService;
import com.example.shop.service.ShopService;
import com.example.shop.service.mapper.OrderInMapper;
import com.example.shop.service.mapper.OrderOutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BuyerRepository buyerRepository;
    private final ProductRepository productRepository;
    private final ShopService shopService;
    private final OrderOutMapper orderOutMapper;
    private final OrderInMapper orderInMapper;

    private final StoreRepository storeRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderOutMapper orderOutMapper,
                            OrderInMapper orderInMapper, BuyerRepository buyerRepository,
                            ProductRepository productRepository, ShopService shopService,
                            StoreRepository storeRepository) {
        this.orderRepository = orderRepository;
        this.orderOutMapper = orderOutMapper;
        this.orderInMapper = orderInMapper;
        this.buyerRepository = buyerRepository;
        this.productRepository = productRepository;
        this.shopService = shopService;
        this.storeRepository = storeRepository;
    }

    public List<OrderOutDto> getOrders(String email) throws ResponseStatusException{
        if (!buyerRepository.existsById(email)) throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, "This buyer wasn't found");
        return orderRepository.getOrderEntitiesByBuyerEmailOrderByOrderId(email).stream().map(orderOutMapper::mapToOrderOutDto).collect(Collectors.toList());
    }

    public void saveOrderEntity(OrderInDto orderInDto){
        orderRepository.save(orderInMapper.mapToOrderEntity(orderInDto));
    }

    public void buyWare(BuyDto buyDto) throws ResponseStatusException {
        Optional<BuyerEntity> buyerEntity = buyerRepository.findById(buyDto.getEmail());
        Optional<ProductEntity> productEntity = productRepository.findById(buyDto.getWare());

        if (!buyerEntity.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This buyer wasn't found");
        if (!productEntity.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This ware wasn't found");
        if (buyerEntity.get().getBalance() < buyDto.getAmount()*productEntity.get().getPrice()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This buyer doesn't have enough money");

        shopService.addWareToStore(new ShopDto(buyDto.getWare(), buyDto.getStore(), (-1)*buyDto.getAmount()));
        buyerRepository.updateBalance(buyDto.getEmail(), buyerEntity.get().getBalance()-buyDto.getAmount()*productEntity.get().getPrice());
        saveOrderEntity(new OrderInDto(buyDto.getWare(), productEntity.get().getPrice(), buyDto.getAmount(),
                        OrderStatus.REGISTRATION, buyDto.getEmail(), buyDto.getStore()));

    }

    public List<OrderOutDto> getNotShippedWares(String store) throws ResponseStatusException{
        if (!storeRepository.existsById(store)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found this store");
        return orderRepository.getNotShippedWares(store).stream().map(orderOutMapper::mapToOrderOutDto).collect(Collectors.toList());
    }

    public void updateOrderStatus(Long orderId, String orderStatus) throws ResponseStatusException{
        OrderStatus newOrderStatus;
        try {
            newOrderStatus = OrderStatus.valueOf(orderStatus);
        }
        catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found this order status");
        }

        if (orderRepository.updateOrderStatus(orderId, newOrderStatus) == 0) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found this orderId");
    }


}
