package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPictureRepository extends JpaRepository<Picture, UUID> {
}
