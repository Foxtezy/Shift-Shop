package com.example.shop.service.impl;

import com.example.shop.model.ShopDto;
import com.example.shop.model.StoreByWareDto;
import com.example.shop.repository.ProductRepository;
import com.example.shop.repository.ShopRepository;
import com.example.shop.repository.StoreRepository;
import com.example.shop.repository.model.ShopEntity;
import com.example.shop.service.ShopService;
import com.example.shop.service.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final ShopMapper shopMapper;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ProductRepository productRepository, ShopMapper shopMapper, StoreRepository storeRepository) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.shopMapper = shopMapper;
        this.storeRepository = storeRepository;
    }

    public ResponseEntity<String> addWareToStore(ShopDto shopDto) throws ResponseStatusException {

        if (!productRepository.existsById(shopDto.getWare())) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found ware");
        if (!storeRepository.existsById(shopDto.getStore())) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found store");

        Optional<ShopEntity> shopEntity = shopRepository.getShopEntityByWareAndStore(shopDto.getWare(), shopDto.getStore());
        if (!shopEntity.isPresent()){
            if (shopDto.getAmount() <= 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough wares");
            shopRepository.save(shopMapper.mapToShopEntity(shopDto));
            return ResponseEntity.status(HttpStatus.CREATED).body("Create new position in '" + shopDto.getStore() + "' store");
        }

        if (shopEntity.get().getAmount() + shopDto.getAmount() < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough wares");
        if (shopEntity.get().getAmount() + shopDto.getAmount() == 0) shopRepository.deleteById(shopEntity.get().getProdId());
        else shopRepository.updateAmount(shopEntity.get().getProdId() ,shopEntity.get().getAmount() + shopDto.getAmount());
        return ResponseEntity.ok("Add wares in '" + shopDto.getStore() + "' store\n Now " + (shopEntity.get().getAmount() + shopDto.getAmount()) + " wares");
    }

    public List<StoreByWareDto> getStoresByWare(String ware){
        return shopRepository.getStoresByWare(ware);
    }

}
