package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShopDTO {

    private Long id;
    private String companyName;
    private String phone;
    private String address;
    private Long sellerId;

}
