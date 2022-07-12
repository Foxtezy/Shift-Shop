package com.example.shop.controller;


import com.example.shop.model.BuyDto;
import com.example.shop.model.OrderOutDto;
import com.example.shop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/{email}")
    @Operation(summary = "Get all the buyer's orders", tags = "Orders")
        @ApiResponse(responseCode = "200", description = "The orders was successfully received")
        @ApiResponse(responseCode = "400", description = "The buyer wasn't found", content = @Content)
    public List<OrderOutDto> getAllOrdersByEmail(@PathVariable String email){
        return orderService.getOrders(email);
    }

    @PostMapping("/buy")
    @Operation(summary = "Make an order", tags = "Orders")
        @ApiResponse(responseCode = "200", description = "The order was successfully placed")
        @ApiResponse(responseCode = "400", description = "There isn't enough money or there aren't enough wares in store")
        @ApiResponse(responseCode = "404", description = "The buyer or ware wasn't found")
    public void makeOrder(BuyDto buyDto){
        orderService.buyWare(buyDto);
    }

    @GetMapping("/registration/{store}")
    @Operation(summary = "Get not shipped wares by store", tags = "Orders")
        @ApiResponse(responseCode = "200", description = "The orders was successfully received")
        @ApiResponse(responseCode = "404", description = "This store wasn't found", content = @Content)
    public List<OrderOutDto> getNotShippedWares(@PathVariable String store){
        return orderService.getNotShippedWares(store);
    }


    @PutMapping("/status/{orderId}")
    @Operation(summary = "Update order status", tags = "Orders")
        @ApiResponse(responseCode = "200", description = "The status was successfully update")
        @ApiResponse(responseCode = "400", description = "Invalid order status")
        @ApiResponse(responseCode = "404", description = "This order id wasn't found")
    public void updateOrderStatus(@PathVariable Long orderId, String orderStatus){
        orderService.updateOrderStatus(orderId, orderStatus);
    }
}
