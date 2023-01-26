package org.example.proxys;

import org.example.dto.SellerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "servicieSeller", url = "http://localhost:8765/SERVICIESELLER/api/v1/seller/")
public interface SellerProxy {


    @GetMapping(value = "{id}")
    SellerDTO getSeller(@PathVariable("id") Long id);


}

