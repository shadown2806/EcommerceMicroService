package com.example.microservicecustomer.proxys;

import com.example.microservicecustomer.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "servicieCustomer", url = "http://localhost:8765/SERVICECUSTOMER/customers/")

public interface ProxyCustomer {

    @GetMapping(value = "{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long id);
}
