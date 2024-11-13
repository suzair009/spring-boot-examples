package com.backend.ecommerce.Service.impl;

import com.backend.ecommerce.Entity.Category;
import com.backend.ecommerce.Service.CategoryService;
import com.backend.ecommerce.repository.CategoryRespoitory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImplementation implements CategoryService {

    private CategoryRespoitory categoryRespoitory;

    @Override
    public Category createCategory(Category category) {
        return categoryRespoitory.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {

        Optional<Category> Id = categoryRespoitory.findById(categoryId);
        return Id.get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRespoitory.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        Category categoryObject = categoryRespoitory.findById(category.getId()).get();
        categoryObject.setCategoryName(category.getCategoryName());
        categoryObject.setDescription(category.getDescription());

        Category updateData  = categoryRespoitory.save(categoryObject);
        return updateData;
    }

    @Override
    public void deleteCategory(Long categoryid) {
        categoryRespoitory.deleteById(categoryid);
    }
}
