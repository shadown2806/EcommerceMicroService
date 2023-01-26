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
public class SellerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String telephone;
    private String username;
    private String password;
    private String email;

}
