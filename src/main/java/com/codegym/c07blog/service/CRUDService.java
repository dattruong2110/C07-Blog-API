package com.codegym.c07blog.service;

import java.util.List;
import java.util.UUID;

public interface CRUDService <T>{
    T findById(UUID id);
    List<T> findAll();
    void save(T t);
    void deleteById (UUID id);
}
