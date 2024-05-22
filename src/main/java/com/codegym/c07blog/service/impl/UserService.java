package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.jwt.JsonWebTokenProvider;
import com.codegym.c07blog.payload.request.LoginRequest;
import com.codegym.c07blog.payload.request.RegisterRequest;
import com.codegym.c07blog.payload.response.LoginResponse;
import com.codegym.c07blog.payload.response.ResponsePayload;
import com.codegym.c07blog.repository.IUserRepository;
import com.codegym.c07blog.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JsonWebTokenProvider jsonWebTokenProvider;

    @Override
    public ResponsePayload login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jsonWebTokenProvider.generateToken(authentication.getName());
            User user = userRepository.findByUsername(loginRequest.getUsername());
            LoginResponse tokenResponse =  LoginResponse.builder()
                    .fullName(user.getFullName())
                    .username(user.getUsername())
                    .token(token)
                    .build();
            return ResponsePayload
                    .builder()
                    .message("Login success")
                    .data(tokenResponse)
                    .status(HttpStatus.OK)
                    .build();

        } catch (Exception e) {
            return ResponsePayload
                    .builder()
                    .message("Login failed")
                    .data(e.getMessage())
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        }
    }

    @Override
    public ResponsePayload register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        String password = passwordEncoder.encode(registerRequest.getPassword());
        user.setPassword(password);
        user.setEmail(registerRequest.getEmail());
        user.setFullName(registerRequest.getFullName());
        userRepository.save(user);
        return ResponsePayload.builder()
                .message("Register success")
                .data(null)
                .status(HttpStatus.OK)
                .build();
    }
}
