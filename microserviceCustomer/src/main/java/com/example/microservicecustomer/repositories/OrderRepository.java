package com.example.microservicecustomer.repositories;

import com.example.microservicecustomer.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
