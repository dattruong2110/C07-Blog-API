package com.codegym.c07blog.entity.Blog;

import com.codegym.c07blog.entity.Picture;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    @OneToOne
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private Picture picture;
    private String content;

    private LocalDateTime timestamps = LocalDateTime.now();


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;


    @OneToOne
    @JoinColumn(name = "blog_user_id", referencedColumnName = "id")
    @JsonIgnore
    private BlogUser blogUser;


    @Column(name = "is_delete")
    private Boolean isDeleted = false;
}
