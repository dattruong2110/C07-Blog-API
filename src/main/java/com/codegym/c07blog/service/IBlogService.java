package com.codegym.c07blog.service;

import com.codegym.c07blog.dto.BlogDTO;
import com.codegym.c07blog.dto.UserDTO;
import com.codegym.c07blog.entity.Blog.Blog;
import com.codegym.c07blog.entity.Blog.BlogUser;
import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.entity.authentication.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBlogService extends CRUDService<Blog>{
    List<Blog> findByTitle(String title);


}
