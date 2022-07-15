package com.example.shop.service.impl;

import com.example.shop.model.ProductDto;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.model.ProductEntity;
import com.example.shop.service.ProductService;
import com.example.shop.component.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public void saveNewProduct(ProductDto productDto) throws ResponseStatusException {
        if (productRepository.existsById(productDto.getWare())) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ware wasn't found");
        productRepository.save(productMapper.mapToProductEntity(productDto));
    }

    public void deleteProduct(String product) throws ResponseStatusException {
        if (productRepository.existsById(product)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ware wasn't found");
        productRepository.deleteById(product);
    }

    public void editProductDescription(String ware, String description) throws ResponseStatusException{
        if (productRepository.editProductDescription(ware, description) == 0) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ware wasn't found");
    }

    public void editProductPrice(String ware, Double price) throws ResponseStatusException{
        if (productRepository.editProductPrice(ware, price) == 0) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ware wasn't found");
    }

    public List<ProductDto> getAllProducts(){
        return ((List<ProductEntity>)productRepository.findAll()).stream().map(productMapper::mapToProductDto).collect(Collectors.toList());
    }
}
