package org.example.controllers;

import org.example.dto.CustomizedProductDTO;
import org.example.dto.SellerDTO;
import org.example.dto.ShopDTO;
import org.example.services.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/seller/")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @PostMapping(value ="{sellerId}/shop/{shopId}/add/customizedProductBySeller")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomizedProductBySeller(@RequestBody CustomizedProductDTO customizedProductDTO, @PathVariable String sellerId, @PathVariable String shopId){
        sellerService.addCustomizedProductBySeller(customizedProductDTO, sellerId, shopId);
    }

    @PostMapping(value = "{sellerId}/add/shopBySeller")
    @ResponseStatus(HttpStatus.CREATED)
    public void addShopBySeller(@RequestBody ShopDTO shopDTO, @PathVariable String sellerId){
        sellerService.addShopBySeller(shopDTO, sellerId);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createSeller(@RequestBody SellerDTO sellerDTO){

        return(sellerService.addSeller(sellerDTO));
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSeller(@PathVariable("id") Long id){
        sellerService.deleteSeller(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public SellerDTO getSeller(@PathVariable("id") Long id){
        return sellerService.getSeller(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<SellerDTO> getAllSeller(){
        return sellerService.getAllSeller();
    }
}
