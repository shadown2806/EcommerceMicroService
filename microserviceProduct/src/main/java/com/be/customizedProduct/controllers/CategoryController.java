package com.be.customizedProduct.controllers;

import com.be.customizedProduct.dto.CategoryDTO;
import com.be.customizedProduct.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category/")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createCategory(@RequestBody CategoryDTO categoryDTO){
        return(categoryService.addCategory(categoryDTO)) ;

    }

    @DeleteMapping(value = "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategory(@PathVariable("id") Long id){
        return categoryService.getCategory(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAllCategory(){
        return categoryService.getAllCategory();
    }
}
