package com.be.customizedProduct.services;

import com.be.customizedProduct.constants.Constants;
import com.be.customizedProduct.dto.CustomizeDTO;
import com.be.customizedProduct.entities.Customize;
import com.be.customizedProduct.exceptions.product.ProductNotFoundException;
import com.be.customizedProduct.mappers.CustomizeMapper;
import com.be.customizedProduct.repositories.CustomizeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomizeService {

    private final CustomizeRepository customizeRepository;
    private final CustomizeMapper customizeMapper;

    public CustomizeService(CustomizeRepository customizeRepository,CustomizeMapper customizeMapper) {
        this.customizeRepository = customizeRepository;
        this.customizeMapper = customizeMapper;
    }

    public Long addCustomize(CustomizeDTO customizeDTO) {
        customizeDTO.setCreatedAt(LocalDate.now());
        Customize customize = customizeMapper.convertToEntity(customizeDTO);
        customizeRepository.save(customize);

        return(customize.getId());
    }

    public void deleteCustomize(Long id) {

        if (!customizeRepository.existsById(id)) {
            throw new ProductNotFoundException(Constants.SELLER_NOT_FOUND + id);
        }
        customizeRepository.deleteById(id);
    }

    public CustomizeDTO getCustomize(Long id) {

        Optional<Customize> customize = customizeRepository.findById(id);
        if (customize.isEmpty()) {

            throw new ProductNotFoundException(Constants.CUSTOMIZED_NOT_FOUND + id);

        }
        return customizeMapper.convertToDto(customize.get());
    }

    public List<CustomizeDTO> getAllCustomize() {
        List<Customize> result = customizeRepository.findAll();
        return customizeMapper.ListConvertToDto(result);
    }

}
