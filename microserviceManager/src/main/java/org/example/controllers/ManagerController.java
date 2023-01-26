package org.example.controllers;

import org.example.dto.CustomizeAreaDTO;
import org.example.dto.ManagerDTO;
import org.example.dto.ProductBaseDTO;
import org.example.services.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/manager/")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping(value = "{managerId}/add/customizeAreaByManager")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomizeAreaByManager(@RequestBody CustomizeAreaDTO customizeAreaDTO, @PathVariable String managerId){
        managerService.addCustomizeAreaByManager(customizeAreaDTO, managerId);
    }

    @PostMapping(value = "{managerId}/add/productBaseByManager")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProductBaseByManager(@RequestBody ProductBaseDTO productBaseDTO, @PathVariable String managerId){
        managerService.addProductBaseByManager(productBaseDTO, managerId);
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createManager(@RequestBody ManagerDTO managerDTO){

        return(managerService.addManager(managerDTO));
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteManager(@PathVariable("id") Long id){
        managerService.deleteManager(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManagerDTO getManager(@PathVariable("id") Long id){
        return managerService.getManager(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDTO> getAllManager(){
        return managerService.getAllManager();
    }
}
