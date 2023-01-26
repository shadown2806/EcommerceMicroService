package org.example.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "Shop")
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    @ElementCollection
    private List<Long> customizedProductList;

    @ManyToOne(targetEntity = Seller.class)
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    private Seller seller;

    public Shop(){

        this.customizedProductList = new ArrayList<>();

    }

}
