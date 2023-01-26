package com.example.microservicecustomer.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Customer")
@Table(name = "customer")
public class Customer extends UserEntity {

    @OneToMany(mappedBy = "customer", targetEntity = Order.class)
    private List<Order> orderList;

}
