package com.codegym.c07blog.controller;

import com.codegym.c07blog.dto.BlogDTO;
import com.codegym.c07blog.entity.Blog.Blog;
import com.codegym.c07blog.entity.Blog.Category;
import com.codegym.c07blog.payload.request.BlogRequest;
import com.codegym.c07blog.service.IBlogService;
import com.codegym.c07blog.service.impl.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> createBlog(@RequestBody BlogRequest blogRequest) {
        blogService.createBlogAndBlogUser(blogRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<BlogDTO>> getAllBlogs() {
        List<BlogDTO> blogs = blogService.getAllBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogWithUserById(@PathVariable UUID id) {
        BlogDTO blogDTO = blogService.getBlogWithUserById(id);

        if (blogDTO != null) {
            return new ResponseEntity<>(blogDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> findByTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(blogService.findByTitle(title));
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    };
}
