package com.codegym.c07blog.controller;

import com.codegym.c07blog.dto.FactDTO;
import com.codegym.c07blog.entity.Fact.Fact;
import com.codegym.c07blog.payload.request.FactRequest;
import com.codegym.c07blog.payload.response.ResponsePayload;
import com.codegym.c07blog.service.IFactService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/fact")
@AllArgsConstructor
public class FactController {
    private final IFactService factService;

    @PostMapping
    public ResponseEntity<ResponsePayload> creatFact(@RequestBody FactRequest factRequest) {
        factService.createFactAndFactUser(factRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<FactDTO>> getAllFacts() {
        List<FactDTO> facts = factService.getAllFacts();
        return new ResponseEntity<>(facts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactDTO> getFactWithUserById(@PathVariable UUID id) {
        FactDTO factDTO = factService.getFactWithUserById(id);

        if (factDTO != null) {
            return new ResponseEntity<>(factDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
