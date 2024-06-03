package com.codegym.c07blog.payload.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String avatar;
}
