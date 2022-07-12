package com.example.shop.service;

import com.example.shop.model.ProductDto;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ProductService {
    void saveNewProduct(ProductDto productDto) throws ResponseStatusException ;
    void deleteProduct(String product) throws ResponseStatusException;
    void editProductDescription(String ware, String description) throws ResponseStatusException;
    void editProductPrice(String ware, Double price) throws ResponseStatusException;

    List<ProductDto> getAllProducts();
}
