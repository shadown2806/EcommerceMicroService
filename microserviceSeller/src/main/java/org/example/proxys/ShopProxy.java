package org.example.proxys;

import org.example.dto.CustomizedProductDTO;
import org.example.dto.ShopDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "servicieShop", url = "http://localhost:8765/SERVICIESELLER/api/v1/shop/")
public interface ShopProxy {

    @PostMapping(value = "add")
    void createShop(@RequestBody ShopDTO shopDTO);

    @GetMapping(value = "{id}")
    ShopDTO getShop(@PathVariable("id") Long id);

    @PostMapping(value = "{shopId}/add/customizedProductByShop")
    void addCustomizedProductsByShop(@PathVariable String shopId, @RequestBody CustomizedProductDTO customizedProductDTO);


    }
