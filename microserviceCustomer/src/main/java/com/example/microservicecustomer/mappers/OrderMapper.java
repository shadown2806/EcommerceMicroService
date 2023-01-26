package com.example.microservicecustomer.mappers;

import com.example.microservicecustomer.dto.OrderDTO;
import com.example.microservicecustomer.entities.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    private final ModelMapper orderMapper;

    public OrderMapper() {
        this.orderMapper = new ModelMapper();
    }


    public List<OrderDTO> ListConvertToDto(List<Order> orderList) {

        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (Order customer : orderList) {
            orderDTOList.add(orderMapper.map(customer, OrderDTO.class));
        }

        return orderDTOList;
    }

    public OrderDTO convertToDto(Order order) {
        return orderMapper.map(order, OrderDTO.class);
    }

    public Order convertToEntity(OrderDTO orderDTO) {
        return orderMapper.map(orderDTO, Order.class);
    }

}
