package com.be.customizedProduct.services;

import  com.be.customizedProduct.constants.Constants;

import com.be.customizedProduct.dto.CustomizeAreaDTO;
import  com.be.customizedProduct.entities.CustomizeArea;
import  com.be.customizedProduct.exceptions.customizedArea.CustomizeAreaNotFoundException;
import com.be.customizedProduct.mappers.CustomizeAreaMapper;
import  com.be.customizedProduct.repositories.CustomizeAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizeAreaService {

    private final CustomizeAreaRepository customizeAreaRepository;
    private final CustomizeAreaMapper customizeAreaMapper;

    public CustomizeAreaService(CustomizeAreaRepository customizeAreaRepository,CustomizeAreaMapper customizeAreaMapper){
        this.customizeAreaRepository = customizeAreaRepository;
        this.customizeAreaMapper = customizeAreaMapper;
    }

    public Long addCustomizeArea(CustomizeAreaDTO customizeAreaDTO) {
        CustomizeArea customizeArea = customizeAreaMapper.convertToEntity(customizeAreaDTO);
        customizeAreaRepository.save(customizeArea);
        return customizeArea.getId();
    }

    public void deleteCustomizeArea(Long id) {

        if (!customizeAreaRepository.existsById(id)) {
            throw new CustomizeAreaNotFoundException(Constants.CUSTOMIZED_AREA_NOT_FOUND + id);
        }

        customizeAreaRepository.deleteById(id);
    }

    public CustomizeAreaDTO getCustomizeArea(Long id) {

        Optional<CustomizeArea> customizeArea = customizeAreaRepository.findById(id);

        if (customizeArea.isEmpty()) {
            throw new CustomizeAreaNotFoundException(Constants.CUSTOMIZED_AREA_NOT_FOUND + id);
        }

        return customizeAreaMapper.convertToDto(customizeArea.get());
    }

    public List<CustomizeAreaDTO> getAllCustomizeArea() {
        List<CustomizeArea> result = customizeAreaRepository.findAll();
        return customizeAreaMapper.ListConvertToDto(result);
    }

}
