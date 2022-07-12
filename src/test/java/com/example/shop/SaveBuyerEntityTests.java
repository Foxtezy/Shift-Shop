package com.example.shop;


import com.example.shop.model.BuyerDto;
import com.example.shop.repository.BuyerRepository;
import com.example.shop.service.BuyerService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class SaveBuyerEntityTests {


    private final BuyerService buyerService;

    @Autowired
    public SaveBuyerEntityTests(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @MockBean
    private BuyerRepository buyerRepository;

    @Test
    public void saveInvalidUser(){
        Mockito.when(buyerRepository.existsById("chuha")).thenReturn(false);
        BuyerDto buyerDto = new BuyerDto("chuha", "chus", "Sample street", 100.2);
        try {
            buyerService.saveBuyerEntity(buyerDto);
        }
        catch (ResponseStatusException e){
            Assert.assertEquals(e.toString(), new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not email").toString());
        }

    }

    @Test
    public void saveValidUser(){
        Mockito.when(buyerRepository.existsById("nmahov2003@gmail.com")).thenReturn(false);
        BuyerDto buyerDto = new BuyerDto("nmahov2003@gmail.com", "", "Sample street", 100.2);
        try {
            buyerService.saveBuyerEntity(buyerDto);
        }
        catch (ResponseStatusException e){
            Assert.fail();
        }

    }




}
