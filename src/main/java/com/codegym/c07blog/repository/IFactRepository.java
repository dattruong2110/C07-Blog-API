package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.Fact.Fact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IFactRepository extends JpaRepository<Fact, UUID> {
}
