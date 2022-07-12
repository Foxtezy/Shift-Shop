package com.example.shop.controller;



import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import com.example.shop.model.BuyerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("buyer")
public class BuyerController {
    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @GetMapping
    @Operation(summary = "Get a buyer by his email", tags = "Buyer")
        @ApiResponse(responseCode = "200", description = "Found the buyer")
        @ApiResponse(responseCode = "404", description = "Buyer not found", content = @Content)
    public  ResponseEntity<BuyerDto> getByEmail(@RequestParam String email){
        return ResponseEntity.ok(buyerService.findByEmail(email));
    }

    @PostMapping
    @Operation(summary = "Save buyer", tags = "Buyer")
        @ApiResponse(responseCode = "200", description = "The buyer is saved")
        @ApiResponse(responseCode = "400", description = "Invalid email")
        @ApiResponse(responseCode = "409", description = "This email is already taken")
    public void saveBuyerEntity(@RequestBody BuyerDto buyerDto) {
        buyerService.saveBuyerEntity(buyerDto);
    }

    @PutMapping
    @Operation(summary = "Edit an existing buyer", tags = "Buyer")
        @ApiResponse(responseCode = "200", description = "The buyer was successfully edited")
        @ApiResponse(responseCode = "404", description = "Buyer not found")
    public void putBuyerEntity(@RequestBody BuyerEntity buyerEntity){
        buyerService.putBuyerEntity(buyerEntity);
    }

    @DeleteMapping
    @Operation(summary = "Delete a buyer by his email", tags = "Buyer")
        @ApiResponse(responseCode = "200", description = "The buyer was successfully deleted")
        @ApiResponse(responseCode = "404", description = "Buyer not found")
    public void deleteBuyerEntity(@RequestParam String login) {
        buyerService.deleteBuyerEntity(login);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all buyers", tags = "Buyer")
        @ApiResponse(responseCode = "200", description = "All buyers were successfully received")
    public List<BuyerDto> getAllBuyerEntity(){
        return buyerService.getAllBuyerEntity();
    }
}
