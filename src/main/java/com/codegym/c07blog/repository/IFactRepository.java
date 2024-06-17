package com.codegym.c07blog.repository;

import com.codegym.c07blog.entity.Fact.Fact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IFactRepository extends JpaRepository<Fact, UUID> {
    List<Fact> findAllByContentContaining(String content);
    @Query("SELECT f FROM Fact f JOIN FactUser fu ON f.id = fu.fact.id JOIN UserRole ur ON fu.userRole.id = ur.id JOIN User u ON ur.user.id = u.id WHERE u.id = :userId")
    List<Fact> findAllByUserId(@Param("userId") UUID userId);
}
