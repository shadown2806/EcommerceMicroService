package com.be.customizedProduct.controllers;

import com.be.customizedProduct.dto.ProductBaseDTO;
import com.be.customizedProduct.services.ProductBaseService;
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
@RequestMapping(path = "api/v1/productsBase/")
public class ProductBaseController {

    private final ProductBaseService productBaseService;

    public ProductBaseController(ProductBaseService productBaseService){
        this.productBaseService = productBaseService;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createProductBase(@RequestBody ProductBaseDTO productBaseDTO){

        return (productBaseService.addProductBase(productBaseDTO));
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductBase(@PathVariable("id") Long id){
        productBaseService.deleteProductBase(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductBaseDTO getProductBase(@PathVariable("id") Long id){
        return productBaseService.getProductBase(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductBaseDTO> getAllProductBase(){
        return productBaseService.getAllProductBase();
    }
}
