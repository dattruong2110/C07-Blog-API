package com.codegym.c07blog.entity.Blog;

import com.codegym.c07blog.entity.authentication.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "blog_id",referencedColumnName = "id")
    private Blog blog;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_role_id",referencedColumnName = "id")
    private UserRole userRole;
}
