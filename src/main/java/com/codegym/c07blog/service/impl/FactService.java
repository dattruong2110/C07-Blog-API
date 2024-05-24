package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.entity.Fact.Fact;
import com.codegym.c07blog.repository.IFactRepository;
import com.codegym.c07blog.service.IFactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FactService implements IFactService {
    private final IFactRepository factRepository;

    @Override
    public Fact findById(UUID id) {return factRepository.findById(id).orElse(null);}

    @Override
    public List<Fact> findAll() {return factRepository.findAll();}

    @Override
    public void save(Fact fact) {factRepository.save(fact);}

    @Override
    public void deleteById(UUID id) {factRepository.deleteById(id);}
}
