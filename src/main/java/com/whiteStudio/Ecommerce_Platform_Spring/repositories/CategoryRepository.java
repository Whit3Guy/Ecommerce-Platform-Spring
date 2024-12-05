package com.whiteStudio.Ecommerce_Platform_Spring.repositories;

import com.whiteStudio.Ecommerce_Platform_Spring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
