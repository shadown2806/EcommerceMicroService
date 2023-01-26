package com.example.microservicecustomer.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity(name = "orders")
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number")
    private Long orderNumber;

    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ElementCollection()
    private List<Long> customizedProductsId;

    public Order(){
        customizedProductsId = new ArrayList<>();
    }



}
