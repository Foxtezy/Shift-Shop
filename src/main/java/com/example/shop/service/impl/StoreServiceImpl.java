package com.example.shop.service.impl;

import com.example.shop.model.StoreDto;
import com.example.shop.repository.StoreRepository;
import com.example.shop.repository.model.StoreEntity;
import com.example.shop.service.StoreService;
import com.example.shop.service.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;

    private final StoreMapper storeMapper;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    public ResponseEntity<String> saveNewStore(StoreDto storeDto){
        if (storeRepository.existsById(storeDto.getStore())){
            storeRepository.save(storeMapper.mapToStoreEntity(storeDto));
            return ResponseEntity.ok("Save new address of '" + storeDto.getStore() + "' store");
        }
        storeRepository.save(storeMapper.mapToStoreEntity(storeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body("Save new store");
    }

    public void deleteStore(String store) throws ResponseStatusException{
        if (!storeRepository.existsById(store)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This store wasn't found");
        storeRepository.deleteById(store);
    }

    public List<StoreDto> getAllStores(){
        return ((List<StoreEntity>)storeRepository.findAll()).stream().map(storeMapper::mapToStoreDto).collect(Collectors.toList());
    }
}
