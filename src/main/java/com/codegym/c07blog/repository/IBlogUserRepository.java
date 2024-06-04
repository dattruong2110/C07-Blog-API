package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.Blog.BlogUser;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogUserRepository extends JpaRepository<BlogUser, UUID> {
}
