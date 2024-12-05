package com.whiteStudio.Ecommerce_Platform_Spring.controllers;


import com.whiteStudio.Ecommerce_Platform_Spring.entities.Product;
import com.whiteStudio.Ecommerce_Platform_Spring.services.ProductService;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public ResponseEntity<List<Product>> GetAllProducts()
    {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> GetProductById(@PathVariable(value = "id") Long id)
    {
        Optional<Product> p = service.findById(id);
        return p.<ResponseEntity<Object>>map(pr -> ResponseEntity.ok().body(pr)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found"));
    }
}
