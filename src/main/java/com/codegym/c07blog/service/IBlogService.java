package com.codegym.c07blog.service;

import com.codegym.c07blog.dto.BlogDTO;
import com.codegym.c07blog.entity.Blog.Blog;

import java.util.List;
import java.util.UUID;

public interface IBlogService extends CRUDService<Blog>{
    List<Blog> findByTitle(String title);
    BlogDTO getBlogWithUserById(UUID Id);
    List<BlogDTO> getAllBlogs();
    BlogDTO mapToBlogDTO(Blog blog);
}
