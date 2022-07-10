package com.example.shop.controller;



import com.example.shop.repository.model.BuyerEntity;
import com.example.shop.service.BuyerService;
import com.example.shop.model.BuyerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import java.util.List;

@RestController
@RequestMapping("buyer")
public class BuyerController {
    private final BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService){
        this.buyerService = buyerService;
    }

    @Operation(summary = "foo", description = "bar")
    @ApiResponse(responseCode = "404", description = "foo")
    @GetMapping
    public ResponseEntity<Object> getByLogin(@RequestParam String login) {
        try {
            return ResponseEntity.status(200).body(buyerService.findByemail(login));
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.toString());
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveBuyerEntity(@RequestBody BuyerDto buyerDto) {
        try {
            return ResponseEntity.ok(buyerService.saveBuyerEntity(buyerDto));
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.toString());
        }
    }

    @PutMapping
    public ResponseEntity<Object> putBuyerEntity(@RequestBody BuyerEntity buyerEntity){
        try {
            return ResponseEntity.ok(buyerService.putBuyerEntity(buyerEntity));
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.toString());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBuyerEntity(@RequestParam String login) {
        try {
            buyerService.deleteBuyerEntity(login);
            return ResponseEntity.ok("OK");
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.toString());
        }
    }

    @GetMapping("/all")
    public List<BuyerDto> getAllBuyerEntity(){
        return buyerService.getAllBuyerEntity();
    }



}
