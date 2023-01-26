package com.be.customizedProduct.mappers;

import com.be.customizedProduct.dto.CustomizedProductDTO;
import com.be.customizedProduct.entities.CustomizedProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomizedProductMapper {

    private final ModelMapper customizedProductMapper;

    public CustomizedProductMapper() {
        this.customizedProductMapper = new ModelMapper();
    }

    public List<CustomizedProductDTO> ListConvertToDto(List<CustomizedProduct> listCustomizedProduct) {

        List<CustomizedProductDTO> listCustomizedProductDTO = new ArrayList<>();

        for (CustomizedProduct customizedProduct : listCustomizedProduct) {
            listCustomizedProductDTO.add(customizedProductMapper.map(customizedProduct, CustomizedProductDTO.class));
        }

        return listCustomizedProductDTO;
    }


    public CustomizedProductDTO convertToDto(CustomizedProduct customizedProduct) {
        return customizedProductMapper.map(customizedProduct, CustomizedProductDTO.class);
    }

    public CustomizedProduct convertToEntity(CustomizedProductDTO customizedProductDTO) {
        return customizedProductMapper.map(customizedProductDTO, CustomizedProduct.class);
    }

}
