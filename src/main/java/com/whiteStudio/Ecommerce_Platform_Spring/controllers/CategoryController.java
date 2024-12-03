package com.whiteStudio.Ecommerce_Platform_Spring.controllers;


import com.whiteStudio.Ecommerce_Platform_Spring.entities.Category;
import com.whiteStudio.Ecommerce_Platform_Spring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController
{
    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public ResponseEntity<List<Category>> GetAllCategories()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> GetCategoryById(@PathVariable(value = "id") Long id)
    {
        Optional<Category> c = service.findById(id);
        return c.<ResponseEntity<Object>>
                map(cat -> ResponseEntity.status(HttpStatus.OK).body(cat)).
                orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found"));
    }
}

