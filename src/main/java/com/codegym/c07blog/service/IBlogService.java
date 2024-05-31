package com.codegym.c07blog.service;

import com.codegym.c07blog.entity.Blog.Blog;

import java.util.List;

public interface IBlogService extends CRUDService<Blog>{
    List<Blog> findByTitle(String title);
}
