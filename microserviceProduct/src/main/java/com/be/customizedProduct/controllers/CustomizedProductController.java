package com.be.customizedProduct.controllers;

import com.be.customizedProduct.dto.CustomizedProductDTO;
import com.be.customizedProduct.services.CustomizedProductService;
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
@RequestMapping(path = "api/v1/customizedProducts/")
public class CustomizedProductController {

    private final CustomizedProductService customizedProductService;

    public CustomizedProductController(CustomizedProductService customizedProductService){
        this.customizedProductService = customizedProductService;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createCustomizedProduct(@RequestBody CustomizedProductDTO customizedProductDTO){
        return(customizedProductService.addCustomizeProduct(customizedProductDTO, customizedProductDTO.getCustomized()));
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomizeProduct(@PathVariable("id") Long id){
        customizedProductService.deleteCustomizeProduct(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomizedProductDTO getCustomizeProduct(@PathVariable("id") Long id){
        return customizedProductService.getCustomizeProduct(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomizedProductDTO> getAllCustomizeProduct(){
        return customizedProductService.getAllCustomizeProduct();
    }
}
