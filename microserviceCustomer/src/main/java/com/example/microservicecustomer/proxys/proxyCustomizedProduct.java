package com.example.microservicecustomer.proxys;

import com.example.microservicecustomer.dto.CustomizedProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicieProducts", url = "http://localhost:8765/SERVICIEPRODUCTS/customizedProducts/")
public interface proxyCustomizedProduct {

    @GetMapping(value = "{id}")
    public CustomizedProductDTO getCustomizeProduct(@PathVariable("id") Long id);

}
