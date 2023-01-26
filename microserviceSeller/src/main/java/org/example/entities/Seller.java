package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "Seller")
@Table(name = "seller")
public class Seller extends UserEntity {

    @OneToMany(mappedBy = "seller")
    private List<Shop> shopList;

    @ManyToMany
    private List<PaymentMethod> paymentMethod;

    public Seller(){
        this.shopList = new ArrayList<>();
        this.paymentMethod = new ArrayList<>();
    }

}
