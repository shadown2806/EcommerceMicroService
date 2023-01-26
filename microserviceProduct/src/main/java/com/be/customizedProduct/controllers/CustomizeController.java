package com.be.customizedProduct.controllers;

import com.be.customizedProduct.dto.CustomizeDTO;
import com.be.customizedProduct.services.CustomizeService;
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
@RequestMapping(path = "api/v1/customize/")
public class CustomizeController {

    private final CustomizeService customizeService;

    public CustomizeController(CustomizeService customizeService) {
        this.customizeService = customizeService;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createCustomize(@RequestBody CustomizeDTO customizeDTO){

        return(customizeService.addCustomize(customizeDTO));
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomize(@PathVariable("id") Long id){
        customizeService.deleteCustomize(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomizeDTO getCustomize(@PathVariable("id") Long id){
        return customizeService.getCustomize(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomizeDTO> getAllCustomize(){
        return customizeService.getAllCustomize();
    }
}
