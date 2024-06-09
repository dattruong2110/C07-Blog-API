package com.codegym.c07blog.service;

import com.codegym.c07blog.dto.UserDTO;
import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.payload.request.LoginRequest;
import com.codegym.c07blog.payload.request.RegisterRequest;
import com.codegym.c07blog.payload.request.UserRequest;
import com.codegym.c07blog.payload.response.ResponsePayload;
import com.codegym.c07blog.payload.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    ResponsePayload login(LoginRequest loginRequest);
    ResponsePayload register(RegisterRequest registerRequest);
    List<User> findAll();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    UserResponse createAdminAccount(UserRequest userRequest, UUID superAdminId) throws Exception;
    UserDTO getBlogByUserID(UUID id);
}
