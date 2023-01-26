package com.be.customizedProduct.repositories;

import com.be.customizedProduct.entities.Customize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface CustomizeRepository extends JpaRepository<Customize, Long> {

    @Query("SELECT id FROM Customize WHERE customizeType = :customizetype AND customizePrice = :customizeprice AND phrase = :phrase")
    Long findCustomizeByTypePrice(
            @Param("customizetype") String customizeType,
            @Param("customizeprice") BigDecimal customizePrice,
            @Param("phrase") String phrase);
}
