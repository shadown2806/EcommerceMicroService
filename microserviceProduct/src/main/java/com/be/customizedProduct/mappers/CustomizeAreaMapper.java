package com.be.customizedProduct.mappers;

import com.be.customizedProduct.dto.CustomizeAreaDTO;
import com.be.customizedProduct.entities.CustomizeArea;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomizeAreaMapper {

    private final ModelMapper customizeAreaMapper;

    public CustomizeAreaMapper() {
        this.customizeAreaMapper = new ModelMapper();
    }

    public List<CustomizeAreaDTO> ListConvertToDto(List<CustomizeArea> customizeAreaList) {

        List<CustomizeAreaDTO> customizeAreaDTOS = new ArrayList<>();

        for (CustomizeArea customizeArea : customizeAreaList) {
            customizeAreaDTOS.add(customizeAreaMapper.map(customizeArea, CustomizeAreaDTO.class));
        }

        return customizeAreaDTOS;
    }

    public CustomizeAreaDTO convertToDto(CustomizeArea customizeArea) {
        return customizeAreaMapper.map(customizeArea, CustomizeAreaDTO.class);
    }

    public CustomizeArea convertToEntity(CustomizeAreaDTO customizeAreaDTO) {
        return customizeAreaMapper.map(customizeAreaDTO, CustomizeArea.class);
    }

}
