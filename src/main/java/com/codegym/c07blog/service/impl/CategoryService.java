package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.entity.Blog.Category;
import com.codegym.c07blog.repository.ICategoryRepository;
import com.codegym.c07blog.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Override
    public Category findById(UUID id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }
}
