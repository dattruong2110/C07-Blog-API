package com.codegym.c07blog.dto;

import com.codegym.c07blog.entity.Picture;
import com.codegym.c07blog.payload.response.UserResponse;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FactDTO {
    private UUID id;
    private Picture picture;
    private String content;
    private String likes;
    private String comment;
    private UserResponse user;
}
