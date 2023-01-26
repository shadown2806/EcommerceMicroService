package org.example.proxys;

import org.example.dto.ProductBaseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "servicieProductBase", url = "http://localhost:8765/SERVICIEPRODUCTS/api/v1/productsBase/")
public interface ProductBaseProxy {

    @PostMapping(value = "add")
    public void createProductBase(@RequestBody ProductBaseDTO productBaseDTO);

}
