package com.codegym.c07blog.payload.request;

import com.codegym.c07blog.entity.Picture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogRequest {
    private String title;
    private String content;
    private Picture picture;
    private String category;
    private UUID userId;
}
