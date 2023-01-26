package com.example.microservicecustomer.services;

import com.example.microservicecustomer.exceptions.customizedPorudct.CustomizedProductNotFoundException;
import com.example.microservicecustomer.proxys.proxyCustomizedProduct;
import com.example.microservicecustomer.constants.Constants;
import com.example.microservicecustomer.entities.Order;
import com.example.microservicecustomer.exceptions.order.OrderNotFoundException;
import com.example.microservicecustomer.repositories.OrderRepository;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.microservicecustomer.dto.OrderDTO;
import com.example.microservicecustomer.mappers.OrderMapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final proxyCustomizedProduct ProxyCustomizedProduct;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository,
                        proxyCustomizedProduct ProxyCustomizedProduct,
                        OrderMapper orderMapper){
        this.orderRepository = orderRepository;
        this.ProxyCustomizedProduct = ProxyCustomizedProduct;
        this.orderMapper = orderMapper;
    }

    public Long addOrder(OrderDTO orderDTO) {

        BigDecimal amountCustomizeProduct;
        List<Long> productsId = orderDTO.getCustomizedProductId();

        for(Long customizedProductId : productsId){


            if(ProxyCustomizedProduct.getCustomizeProduct(customizedProductId) != null){
                amountCustomizeProduct = ProxyCustomizedProduct.getCustomizeProduct(customizedProductId).getPrice();
                orderDTO.setOrderAmount(orderDTO.getOrderAmount().add(amountCustomizeProduct));
            }else{
                throw new CustomizedProductNotFoundException(Constants.ORDER_NOT_FOUND + productsId);
            }
        }
        Order order = orderMapper.convertToEntity(orderDTO);
        order.setCustomizedProductsId(productsId);
        orderRepository.save(order);

        return(order.getOrderNumber());
    }

    public void deleteOrder(Long id) {

        if (!orderRepository.existsById(id)) {

            throw new OrderNotFoundException(Constants.ORDER_NOT_FOUND + id);

        }

        orderRepository.deleteById(id);
    }

    public OrderDTO getOrder(Long id) {

        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {

            throw new OrderNotFoundException(Constants.ORDER_NOT_FOUND + id);

        }

        return orderMapper.convertToDto(order.get());
    }

    public List<OrderDTO> getAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.ListConvertToDto(orders);
    }


}
