package com.codegym.c07blog.service;

import com.codegym.c07blog.dto.FactDTO;
import com.codegym.c07blog.entity.Fact.Fact;
import com.codegym.c07blog.payload.request.FactRequest;
import com.codegym.c07blog.payload.response.ResponsePayload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IFactService extends CRUDService<Fact> {
    List<Fact> findByContent(String content);
    FactDTO getFactWithUserById(UUID Id);
    List<FactDTO> getAllFacts();
    FactDTO mapToFactDTO(Fact fact);
    ResponsePayload createFactAndFactUser (FactRequest factRequest);
}
