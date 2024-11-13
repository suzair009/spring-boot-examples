package com.backend.ecommerce.repository;

import com.backend.ecommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespoitory extends JpaRepository<Category,Long> {
}
