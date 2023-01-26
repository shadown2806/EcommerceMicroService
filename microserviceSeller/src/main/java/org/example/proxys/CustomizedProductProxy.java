package org.example.proxys;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.example.dto.CustomizedProductDTO;

@FeignClient(name = "servicieProducts", url = "http://localhost:8765/SERVICIEPRODUCTS/api/v1/customizedProducts/")
public interface CustomizedProductProxy {

    @PostMapping(value = "add")
    void  createCustomizedProduct(@RequestBody CustomizedProductDTO customizedProductDTO);

}
