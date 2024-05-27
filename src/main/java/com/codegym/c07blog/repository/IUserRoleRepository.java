package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.authentication.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, UUID> {
}
