package com.codegym.c07blog.entity.authentication;

import com.codegym.c07blog.entity.Blog.BlogUser;
import com.codegym.c07blog.entity.Fact.Fact;
import com.codegym.c07blog.entity.Fact.FactUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToMany(mappedBy = "userRole")
    @JsonManagedReference
    private List<BlogUser> blogUsers;

    @OneToMany(mappedBy = "userRole")
    @JsonBackReference
    private List<FactUser> factUsers;
}
