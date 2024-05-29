package com.codegym.c07blog.service;

import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.payload.request.LoginRequest;
import com.codegym.c07blog.payload.request.RegisterRequest;
import com.codegym.c07blog.payload.response.ResponsePayload;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    ResponsePayload login(LoginRequest loginRequest);
    ResponsePayload register(RegisterRequest registerRequest);
    List<User> findAll();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User createAdminAccount(User user, UUID superAdminId) throws Exception;
}
