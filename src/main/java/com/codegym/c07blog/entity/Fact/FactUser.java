package com.codegym.c07blog.entity.Fact;

import com.codegym.c07blog.entity.authentication.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FactUser {
   @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

   @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "fact_id", referencedColumnName = "id")
    private Fact fact;

   @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    private UserRole userRole;
}
