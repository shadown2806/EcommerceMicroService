package com.be.customizedProduct.repositories;

import com.be.customizedProduct.entities.ProductBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductBaseRepository  extends JpaRepository <ProductBase, Long>{
}
