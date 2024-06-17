package com.codegym.c07blog.payload.request;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRequest {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String avatar;
}
