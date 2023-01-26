package org.example.dto;

import java.math.BigDecimal;
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
public class CustomizedProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Long customizeAreaId;
    private Long productBaseId;
    private CategoryDTO categoryDTO;
    private CustomizeDTO customized;

}