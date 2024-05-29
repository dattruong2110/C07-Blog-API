package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.Blog.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IBlogRepository extends CrudRepository<Blog, UUID> {
}
