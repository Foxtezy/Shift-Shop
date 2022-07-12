package com.example.shop.controller;


import com.example.shop.model.ProductDto;
import com.example.shop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    @Operation(summary = "Add new product", tags = "Product")
        @ApiResponse(responseCode = "200", description = "The ware was successfully save")
        @ApiResponse(responseCode = "404", description = "This order id wasn't found")
    public void addWare(ProductDto productDto){
        productService.saveNewProduct(productDto);
    }

    @DeleteMapping
    @Operation(summary = "Delete product", tags = "Product")
        @ApiResponse(responseCode = "200", description = "The ware was successfully delete")
        @ApiResponse(responseCode = "404", description = "This ware wasn't found")
    public void deleteWare(String ware){
        productService.deleteProduct(ware);
    }

    @PutMapping("/description")
    @Operation(summary = "Edit description of the product", tags = "Product")
        @ApiResponse(responseCode = "200", description = "The description was successfully edit")
        @ApiResponse(responseCode = "404", description = "This ware wasn't found")
    public void editWareDescription(String ware, String description){
        productService.editProductDescription(ware, description);
    }

    @PutMapping("/price")
    @Operation(summary = "Edit the product price", tags = "Product")
        @ApiResponse(responseCode = "200", description = "The price was successfully edit")
        @ApiResponse(responseCode = "404", description = "This ware wasn't found")
    public void editWarePrice(String ware, Double price){

    }

    @GetMapping
    @Operation(summary = "Get all products", tags = "Product")
        @ApiResponse(responseCode = "200", description = "The products was successfully received")
    public List<ProductDto> getAllWares(){
        return productService.getAllProducts();
    }
}
