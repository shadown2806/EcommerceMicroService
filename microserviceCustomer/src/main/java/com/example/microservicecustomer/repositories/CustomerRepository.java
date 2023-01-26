package com.example.microservicecustomer.repositories;

import com.example.microservicecustomer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
