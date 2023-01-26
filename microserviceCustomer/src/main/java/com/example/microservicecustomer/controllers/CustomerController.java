package com.example.microservicecustomer.controllers;

import com.example.microservicecustomer.dto.CustomerDTO;
import com.example.microservicecustomer.dto.OrderDTO;
import com.example.microservicecustomer.services.CustomerService;
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
@RequestMapping(path = "api/v1/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createCustomer(@RequestBody CustomerDTO customerDTO){

        return (customerService.addCustomer(customerDTO));
    }

    @PostMapping(value = "{idCustomer}/addCustomizedProductOnOrderByRegisterCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomizedProductOnOrderByRegisterCustomer(@RequestBody OrderDTO orderDTO, @PathVariable String idCustomer){

        customerService.addCustomizedProductOnOrderByRegisterCustomer(orderDTO, idCustomer);
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomer(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
