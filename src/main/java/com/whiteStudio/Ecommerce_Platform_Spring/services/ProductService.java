package com.whiteStudio.Ecommerce_Platform_Spring.services;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.Product;
import com.whiteStudio.Ecommerce_Platform_Spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository _rep;

    public List<Product> findAll()
    {
        return _rep.findAll();
    }

    public Optional<Product> findById(Long id)
    {
        return _rep.findById(id);
    }
}
