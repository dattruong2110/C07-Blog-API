package com.codegym.c07blog.controller;

import com.codegym.c07blog.entity.Fact.Fact;
import com.codegym.c07blog.service.IFactService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/fact")
@AllArgsConstructor
public class FactController {
    private final IFactService factService;
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Fact fact) {
        factService.save(fact);
        return ResponseEntity.ok("Thêm bài viết thành công");
    }

    @GetMapping
    public ResponseEntity<List<Fact>> findAll() {return ResponseEntity.ok(factService.findAll());}

    @GetMapping("/{factId}")
    public ResponseEntity<Fact> findById(@PathVariable ("factId")UUID id) {
        return ResponseEntity.ok(factService.findById(id));}
}
