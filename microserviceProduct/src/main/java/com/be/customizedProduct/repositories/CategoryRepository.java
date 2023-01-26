package com.be.customizedProduct.repositories;

import com.be.customizedProduct.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
