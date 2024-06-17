package com.codegym.c07blog.entity.Fact;

import com.codegym.c07blog.entity.Picture;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private Picture picture;
    private String content;
    private String likes;
    private String comment;
    private LocalDateTime timestamps = LocalDateTime.now();

    @OneToOne(mappedBy = "fact")
    @JsonIgnore
    private FactUser factUser;
}
