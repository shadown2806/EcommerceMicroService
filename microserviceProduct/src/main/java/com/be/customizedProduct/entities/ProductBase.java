package com.be.customizedProduct.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_base")
public class ProductBase {

    @Id
    @Column(name = "product_code")
    private Long productCode;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;


    @ManyToOne(targetEntity = CustomizeArea.class)
    @JoinColumn(name = "customize_area_id",referencedColumnName = "id")
    private CustomizeArea customizeArea;


    @Column(name = "manager_id")
    private Long managerId;

    public ProductBase() {
    }
}
