package com.example.microservicecustomer.controllers;

import com.example.microservicecustomer.dto.OrderDTO;
import com.example.microservicecustomer.entities.Order;
import com.example.microservicecustomer.mappers.OrderMapper;
import com.example.microservicecustomer.services.OrderService;
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
@RequestMapping(path = "api/v1/order/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createOrder(@RequestBody OrderDTO orderDTO){

        return(orderService.addOrder(orderDTO));
    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO getOrder(@PathVariable("id") Long id){
        return orderService.getOrder(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getAllOrder(){
        return orderService.getAllOrder();
    }
}
