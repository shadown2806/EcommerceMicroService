package com.be.customizedProduct.services;

import  com.be.customizedProduct.constants.Constants;
import com.be.customizedProduct.dto.CategoryDTO;
import  com.be.customizedProduct.entities.Category;
import  com.be.customizedProduct.exceptions.category.CategoryNotFoundException;
import com.be.customizedProduct.mappers.CategoryMapper;
import  com.be.customizedProduct.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Long addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.convertToEntity(categoryDTO);
        categoryRepository.save(category);
        return category.getId();
    }

    public void deleteCategory(Long id) {

        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND + id);
        }

        categoryRepository.deleteById(id);
    }

    public CategoryDTO getCategory(Long id) {

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            throw new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND + id);
        }

        return categoryMapper.convertToDto(category.get());
    }

    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.ListConvertToDto(categories);
    }
}
