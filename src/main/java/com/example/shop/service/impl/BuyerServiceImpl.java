package com.example.shop.service.impl;

import com.example.shop.model.BuyDto;
import com.example.shop.repository.BuyerRepository;
import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import com.example.shop.model.BuyerDto;
import com.example.shop.component.BuyerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    private final BuyerMapper buyerMapper;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository, BuyerMapper buyerMapper) {
        this.buyerRepository = buyerRepository;
        this.buyerMapper = buyerMapper;
    }


    public BuyerDto findByEmail(String email) throws ResponseStatusException{
        Optional<BuyerEntity> optionalBuyerEntity = buyerRepository.findById(email);
        if (!optionalBuyerEntity.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This buyer wasn't found");
        return buyerMapper.mapToBuyerDto(optionalBuyerEntity.get());
    }

    public void saveBuyerEntity(BuyerDto buyerDto) throws ResponseStatusException {
        BuyerEntity buyerEntity = buyerMapper.mapToBuyerEntity(buyerDto);
        if (buyerRepository.existsById(buyerEntity.getEmail())) throw new ResponseStatusException(HttpStatus.CONFLICT, "This email already busy");
        Pattern pEmail = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z]+[.][A-Za-z]+$");
        Matcher matcher = pEmail.matcher(buyerEntity.getEmail());
        if (!matcher.find()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not email");
        buyerRepository.save(buyerEntity);
    }

    public void putBuyerEntity(BuyerEntity buyerEntity) throws ResponseStatusException{
        if (buyerRepository.existsById(buyerEntity.getEmail())) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This buyer wasn't found");
        buyerRepository.save(buyerEntity);
    }

    public void deleteBuyerEntity(String email) throws ResponseStatusException{
        if (!buyerRepository.existsById(email)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This buyer wasn't found");
        buyerRepository.deleteById(email);
    }

    public List<BuyerDto> getAllBuyerEntity(){
        return ((List<BuyerEntity>)buyerRepository.findAll()).stream().map(buyerMapper::mapToBuyerDto).collect(Collectors.toList());
    }

    public Integer updateBalance(BuyDto buyDto, Double newBalance){
        return buyerRepository.updateBalance(buyDto.getEmail(), newBalance);
    }




}
