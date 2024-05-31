package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.entity.Blog.Blog;
import com.codegym.c07blog.repository.IBlogRepository;
import com.codegym.c07blog.service.IBlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BlogService implements IBlogService {
    private  final IBlogRepository blogRepository;

    @Override
    public Blog findById(UUID id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return List.of();
    }


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(UUID id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByTitle(String title) {
        return blogRepository.findByTitleContainingIgnoreCase((title));
    }
}
