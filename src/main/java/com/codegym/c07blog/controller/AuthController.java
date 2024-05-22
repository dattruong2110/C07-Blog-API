package com.codegym.c07blog.controller;

import com.codegym.c07blog.payload.request.LoginRequest;
import com.codegym.c07blog.payload.request.RegisterRequest;
import com.codegym.c07blog.payload.response.ResponsePayload;
import com.codegym.c07blog.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponsePayload> login(@RequestBody LoginRequest loginRequest) {
        ResponsePayload responsePayload = userService.login(loginRequest);
        return ResponseEntity.ok(responsePayload);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponsePayload> register(@RequestBody RegisterRequest registerRequest) {
        ResponsePayload responsePayload = userService.register(registerRequest);
        return ResponseEntity.ok(responsePayload);
    }
}
