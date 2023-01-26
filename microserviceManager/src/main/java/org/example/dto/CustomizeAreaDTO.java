package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomizeAreaDTO {

    private Long id;
    private String area;
    private LocalDate createdAt;
    private CustomizeDTO customize;

}
