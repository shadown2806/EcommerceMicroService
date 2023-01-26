package com.be.customizedProduct.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "customize")
public class Customize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="customize_type")
    private String customizeType;
    @Column(name="customize_price")
    private BigDecimal customizePrice;
    @Column(name="image")
    private String image;
    @Column(name="phrase")
    private String phrase;

    @ManyToOne(targetEntity = CustomizeArea.class)
    @JoinColumn(name = "customize_area_id", referencedColumnName = "id")
    private CustomizeArea customizeArea;

}
