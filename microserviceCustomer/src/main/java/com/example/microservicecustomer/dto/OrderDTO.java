package com.example.microservicecustomer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderDTO {

    private BigDecimal orderAmount;
    private CustomerDTO customerDTO;
    private List<Long> customizedProductId;

    public OrderDTO(){

        customizedProductId = new ArrayList<>();

    }
}
