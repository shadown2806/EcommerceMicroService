package com.be.customizedProduct.repositories;

import com.be.customizedProduct.entities.CustomizedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomizedProductRepository extends JpaRepository<CustomizedProduct, Long> {


}
