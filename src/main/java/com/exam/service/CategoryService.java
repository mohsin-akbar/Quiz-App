package com.exam.service;

import com.exam.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category);
    Category getCategory(long id);
    List<Category> getAllCategories();
    void deleteCategory(long id);
}
