package com.codegym.c07blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private UUID id;
    private String username;
    private String email;
    private String fullName;
    private String avatar;
    private Set<BlogDTO> blogs;
}
