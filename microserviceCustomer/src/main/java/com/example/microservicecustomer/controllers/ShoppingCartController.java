/*
package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.ShoppingCartDTO;
import com.credicoop.utn.mappers.ShoppingCartMapper;
import com.credicoop.utn.services.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shoppingCart/")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;


    public ShoppingCartController(ShoppingCartService shoppingCartService, ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createShoppingCart(@RequestBody ShoppingCartDTO shoppingCartDTO){

        shoppingCartDTO.setCreatedAt(LocalDate.now());

        ShoppingCart shoppingCart = shoppingCartMapper.convertToEntity(shoppingCartDTO);
        shoppingCartService.addShoppingCart(shoppingCart);
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShoppingCart(@PathVariable("id") Long id){

        shoppingCartService.deleteShoppingCart(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShoppingCartDTO getShoppingCart(@PathVariable("id") Long id){

        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(id);
        return shoppingCartMapper.convertToDto(shoppingCart);
    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingCartDTO> getAllShoppingCart(){

        List<ShoppingCart> shoppingCart = shoppingCartService.getAllShoppingCart();
        return shoppingCartMapper.ListConvertToDto(shoppingCart);
    }

}
*/