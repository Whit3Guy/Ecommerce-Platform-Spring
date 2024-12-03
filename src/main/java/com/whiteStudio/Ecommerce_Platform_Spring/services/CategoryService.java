package com.whiteStudio.Ecommerce_Platform_Spring.services;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.Category;
import com.whiteStudio.Ecommerce_Platform_Spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository _rep;

    public List<Category> findAll()
    {
        return _rep.findAll();
    }

    public Optional<Category> findById(Long id)
    {
        return _rep.findById(id);
    }
}
