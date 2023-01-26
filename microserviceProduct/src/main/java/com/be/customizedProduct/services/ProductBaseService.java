package com.be.customizedProduct.services;


import  com.be.customizedProduct.constants.Constants;
import com.be.customizedProduct.dto.ProductBaseDTO;
import  com.be.customizedProduct.entities.ProductBase;
import  com.be.customizedProduct.exceptions.product.ProductNotFoundException;
import com.be.customizedProduct.mappers.ProductBaseMapper;
import  com.be.customizedProduct.repositories.ProductBaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBaseService {

    private final ProductBaseRepository productBaseRepository;
    private final ProductBaseMapper productBaseMapper;

    public ProductBaseService(ProductBaseRepository productBaseRepository,ProductBaseMapper productBaseMapper){
        this.productBaseRepository = productBaseRepository;
        this.productBaseMapper = productBaseMapper;
    }

    public Long addProductBase(ProductBaseDTO productBaseDTO) {
        ProductBase productBase = productBaseMapper.convertToEntity(productBaseDTO);
        productBaseRepository.save(productBase);
        return(productBase.getProductCode());
    }

    public void deleteProductBase(Long id) {

        if (!productBaseRepository.existsById(id)) {
            throw new ProductNotFoundException(Constants.PRODUCT_BASE_NOT_FOUND + id);
        }

        productBaseRepository.deleteById(id);
    }

    public ProductBaseDTO getProductBase(Long id) {

        Optional<ProductBase> product = productBaseRepository.findById(id);

        if (product.isEmpty()) {
            throw new ProductNotFoundException(Constants.PRODUCT_BASE_NOT_FOUND + id);
        }

        return productBaseMapper.convertToDto(product.get());
    }

    public List<ProductBaseDTO> getAllProductBase() {
        List<ProductBase> result = productBaseRepository.findAll();
        return productBaseMapper.ListConvertToDto(result);
    }

}
