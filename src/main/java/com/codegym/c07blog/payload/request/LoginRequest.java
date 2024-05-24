package com.codegym.c07blog.payload.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
