package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.Blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IBlogRepository extends JpaRepository<Blog, UUID> {
}
