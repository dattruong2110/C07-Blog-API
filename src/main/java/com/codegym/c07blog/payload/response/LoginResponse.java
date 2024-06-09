package com.codegym.c07blog.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class LoginResponse {
    private UUID id;
    private String username;
    private String token;
    private String fullName;
    private String avatar;
    private List<String> roles;
}
