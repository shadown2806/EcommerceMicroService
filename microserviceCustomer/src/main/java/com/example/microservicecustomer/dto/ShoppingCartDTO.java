package com.example.microservicecustomer.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingCartDTO {

    private Long id;
    private BigDecimal cartPriceAmount;
    private int quantity;
    private Boolean empty;
    private LocalDate createdAt;
}
