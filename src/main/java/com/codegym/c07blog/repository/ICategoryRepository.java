package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.Blog.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICategoryRepository extends JpaRepository<Category, UUID> {
    Category findByName(String name);
}
