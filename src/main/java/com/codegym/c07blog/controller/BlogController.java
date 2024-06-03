package com.codegym.c07blog.controller;

import com.codegym.c07blog.entity.Blog.Blog;
import com.codegym.c07blog.service.IBlogService;
import com.codegym.c07blog.service.impl.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/blog")
@AllArgsConstructor
public class BlogController {
    private final IBlogService blogService;
    private final BlogService BlogService;
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Blog blog){
        blogService.save(blog);
        return ResponseEntity.ok("thêm blog thành công");
    }
    @GetMapping
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> blogs = blogService.findAll();
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable ("id")UUID id){
        return ResponseEntity.ok(blogService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> findByTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(blogService.findByTitle(title));
    }
}
