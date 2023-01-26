package org.example.controllers;

import org.example.dto.CustomizedProductDTO;
import org.example.dto.ShopDTO;
import org.example.services.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shop/")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "{shopId}/add/customizedProductByShop")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomizedProductsByShop(@PathVariable String shopId, @RequestBody CustomizedProductDTO customizedProductDTO){
        shopService.addCustomizedProductByShop(customizedProductDTO, shopId);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createShop(@RequestBody ShopDTO shopDTO){

        return(shopService.addShop(shopDTO));
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShop(@PathVariable("id") Long id){
        shopService.deleteShop(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShopDTO getShop(@PathVariable("id") Long id){
        return shopService.getShop(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ShopDTO> getAllShop(){
        return shopService.getAllShop();
    }
}
