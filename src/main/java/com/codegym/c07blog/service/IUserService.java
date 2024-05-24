package com.codegym.c07blog.service;

import com.codegym.c07blog.payload.request.LoginRequest;
import com.codegym.c07blog.payload.request.RegisterRequest;
import com.codegym.c07blog.payload.response.ResponsePayload;

public interface IUserService {
    ResponsePayload login(LoginRequest loginRequest);
    ResponsePayload register(RegisterRequest registerRequest);
}
