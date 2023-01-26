package com.be.customizedProduct.services;

import com.be.customizedProduct.constants.Constants;
import com.be.customizedProduct.dto.CustomizeAreaDTO;
import com.be.customizedProduct.dto.CustomizeDTO;
import com.be.customizedProduct.dto.CustomizedProductDTO;
import com.be.customizedProduct.dto.ProductBaseDTO;
import com.be.customizedProduct.entities.Category;
import com.be.customizedProduct.entities.CustomizedProduct;
import com.be.customizedProduct.entities.ProductBase;
import com.be.customizedProduct.exceptions.product.ProductNotFoundException;
import com.be.customizedProduct.mappers.CategoryMapper;
import com.be.customizedProduct.mappers.CustomizedProductMapper;
import com.be.customizedProduct.mappers.ProductBaseMapper;
import com.be.customizedProduct.repositories.CustomizeRepository;
import com.be.customizedProduct.repositories.CustomizedProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@Service
public class CustomizedProductService {

    private final CustomizedProductRepository customizedProductRepository;
    private final CategoryMapper categoryMapper;
    private final CustomizeRepository customizeRepository;
    private final CustomizedProductMapper customizedProductMapper;
    private final ProductBaseMapper productBaseMapper;
    private final ProductBaseService productBaseService;
    private final CategoryService categoryService;
    private final CustomizeAreaService customizeAreaService;
    private final CustomizeService customizeService;

    public CustomizedProductService(CustomizedProductRepository customizedProductRepository,
                                    CategoryMapper categoryMapper,
                                    CustomizeRepository customizeRepository,
                                    CustomizedProductMapper customizedProductMapper,
                                    ProductBaseMapper productBaseMapper,
                                    ProductBaseService productBaseService,
                                    CategoryService categoryService,
                                    CustomizeAreaService customizeAreaService,
                                    CustomizeService customizeService) {
        this.customizedProductRepository = customizedProductRepository;
        this.categoryMapper = categoryMapper;
        this.customizeRepository = customizeRepository;
        this.customizedProductMapper = customizedProductMapper;
        this.productBaseMapper = productBaseMapper;
        this.productBaseService = productBaseService;
        this.categoryService = categoryService;
        this.customizeAreaService = customizeAreaService;
        this.customizeService = customizeService;
    }

    public Long addCustomizeProduct(CustomizedProductDTO customizedProductDTO, CustomizeDTO customizeDTO) {

        CustomizedProduct customizedProduct = customizedProductMapper.convertToEntity(customizedProductDTO);

        ProductBase productBase = productBaseMapper.convertToEntity(productBaseService.getProductBase(customizedProductDTO.getProductBaseId()));
        customizedProduct.setProductBaseId(productBase);
        customizedProduct.setCustomizedAreaId(customizedProductDTO.getCustomizeAreaId());

        if(customizedProduct.getCategoryId().getId() != null){

            Category category = categoryMapper.convertToEntity(categoryService.getCategory(customizedProduct.getCategoryId().getId()));
            customizedProduct.setCategoryId(category);
        }else{

            new RestTemplate().postForLocation("http://localhost:8081/api/v1/category/add", customizedProduct.getCategoryId());
            customizedProduct.setCategoryId(customizedProduct.getCategoryId());
        }


        customizeDTO.setCustomizedAreaId(customizeAreaService.getCustomizeArea(customizedProduct.getCustomizedAreaId()).getId());


        Long custId = customizeRepository.findCustomizeByTypePrice(customizeDTO.getCustomizeType(), customizeDTO.getCustomizePrice(), customizeDTO.getPhrase());

        if(custId == null){

            customizeService.addCustomize(customizeDTO);


            custId = customizeRepository.findCustomizeByTypePrice(customizeDTO.getCustomizeType(), customizeDTO.getCustomizePrice(), customizeDTO.getPhrase());
            customizedProduct.setCustomizedId(custId);

        }else{
            customizedProduct.setCustomizedId(custId);
        }


        customizedProduct.setPrice(productBase.getPrice().add(customizeDTO.getCustomizePrice()));

        CustomizeAreaDTO consultCustomizeArea = customizeAreaService.getCustomizeArea(customizedProduct.getCustomizedAreaId());
        ProductBaseDTO productBaseDTO = productBaseService.getProductBase(customizedProduct.getProductBaseId().getProductCode());

        if(consultCustomizeArea !=null && productBaseDTO != null){
            customizedProductRepository.save(customizedProduct);
        }

        return (customizedProduct.getId());
    }

    public void deleteCustomizeProduct(Long id) {

        if (!customizedProductRepository.existsById(id)) {
            throw new ProductNotFoundException(Constants.CUSTOMIZED_PRODUCT_NOT_FOUND + id);
        }

        customizedProductRepository.deleteById(id);
    }

    public CustomizedProductDTO getCustomizeProduct(Long id) {

        Optional<CustomizedProduct> product = customizedProductRepository.findById(id);

        if (product.isEmpty()) {
            throw new ProductNotFoundException(Constants.CUSTOMIZED_PRODUCT_NOT_FOUND + id);
        }

        return customizedProductMapper.convertToDto(product.get());
    }


    public List<CustomizedProductDTO> getAllCustomizeProduct() {
        List<CustomizedProduct> result = customizedProductRepository.findAll();
        return customizedProductMapper.ListConvertToDto(result);
    }

}
