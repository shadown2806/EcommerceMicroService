package com.be.customizedProduct.controllers;

import com.be.customizedProduct.dto.CustomizeAreaDTO;
import com.be.customizedProduct.entities.CustomizeArea;
import com.be.customizedProduct.mappers.CustomizeAreaMapper;
import com.be.customizedProduct.services.CustomizeAreaService;
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
@RequestMapping(path = "api/v1/customizeArea/")
public class CustomizeAreaController {

    private final CustomizeAreaService customizeAreaService;

    public CustomizeAreaController(CustomizeAreaService customizeAreaService){
        this.customizeAreaService = customizeAreaService;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createCustomizeArea(@RequestBody CustomizeAreaDTO customizeAreaDTO){
        return(customizeAreaService.addCustomizeArea(customizeAreaDTO));
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomizeArea(@PathVariable("id") Long id){
        customizeAreaService.deleteCustomizeArea(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomizeAreaDTO getCustomizeArea(@PathVariable("id") Long id){
        return customizeAreaService.getCustomizeArea(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomizeAreaDTO> getAllCustomizeArea(){
        return customizeAreaService.getAllCustomizeArea();
    }
}
