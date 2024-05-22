package com.codegym.c07blog.entity;

import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.entity.authentication.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;

    @OneToMany
    private Set<UserRole> userRoles;
}
