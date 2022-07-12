package com.example.shop.service.mapper;


import com.example.shop.model.ProductDto;
import com.example.shop.repository.model.ProductEntity;
import org.springframework.stereotype.Service;


@Service
public class ProductMapper {

    public ProductEntity mapToProductEntity(ProductDto productDto){
        return new ProductEntity(productDto.getWare(), productDto.getPrice(), productDto.getDescription());
    }

    public ProductDto mapToProductDto(ProductEntity productEntity){
        return new ProductDto(productEntity.getWare(), productEntity.getPrice(), productEntity.getDescription());
    }
}
