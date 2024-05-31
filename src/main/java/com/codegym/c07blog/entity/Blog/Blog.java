package com.codegym.c07blog.entity.Blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime timestamps = LocalDateTime.now();
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @OneToMany
    private Set<BlogUser> blogUserSet;
}
