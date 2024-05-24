package com.codegym.c07blog.entity.Fact;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Fact {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String content;
    private String media;
    private LocalDateTime timestamps = LocalDateTime.now();
    private String likes;
    private String comment;
}
