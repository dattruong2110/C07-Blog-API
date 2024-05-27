package com.codegym.c07blog.entity.Blog;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String user;
    @OneToOne
    private Blog blog;


}
