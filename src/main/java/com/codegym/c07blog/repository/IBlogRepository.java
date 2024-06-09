package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.Blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IBlogRepository extends JpaRepository<Blog, UUID> {
    List<Blog> findByTitleContainingIgnoreCase(String title);
    @Query("SELECT b FROM Blog b JOIN BlogUser bu ON b.id = bu.blog.id JOIN UserRole ur ON bu.userRole.id = ur.id JOIN User u ON ur.user.id = u.id WHERE u.id = :userId")
    List<Blog> findAllByUserId(@Param("userId") UUID userId);
}
