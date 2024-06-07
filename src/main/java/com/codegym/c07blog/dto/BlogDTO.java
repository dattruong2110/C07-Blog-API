package com.codegym.c07blog.dto;

import com.codegym.c07blog.entity.Blog.Category;
import com.codegym.c07blog.entity.Picture;
import com.codegym.c07blog.payload.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogDTO {
    private UUID id;
    private String title;
    private String content;
    private Picture picture;
    private String category;
    private UserResponse user;
}
