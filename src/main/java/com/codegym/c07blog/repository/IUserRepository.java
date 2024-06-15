package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);

//    @Query("SELECT r.userRoles FROM User u JOIN u.userRole ur JOIN ur.role r WHERE u.username = :username")
    @Query("select r.name from UserRole ur join User u on ur.id = u.id join Role r on ur.id = r.id")
    List<String> findRoleByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.isDeleted = true WHERE u.id = :id")
    void deleteUserById(@Param("id") UUID id);
}
