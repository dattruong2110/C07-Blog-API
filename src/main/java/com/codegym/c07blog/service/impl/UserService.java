package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.entity.authentication.Role;
import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.entity.authentication.UserRole;
import com.codegym.c07blog.jwt.JsonWebTokenProvider;
import com.codegym.c07blog.payload.request.LoginRequest;
import com.codegym.c07blog.payload.request.RegisterRequest;
import com.codegym.c07blog.payload.response.LoginResponse;
import com.codegym.c07blog.payload.response.ResponsePayload;
import com.codegym.c07blog.repository.IRoleRepository;
import com.codegym.c07blog.repository.IUserRepository;
import com.codegym.c07blog.repository.IUserRoleRepository;
import com.codegym.c07blog.service.IUserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IUserRoleRepository userRoleRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JsonWebTokenProvider jsonWebTokenProvider;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

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
        user.setAvatar(registerRequest.getAvatar());
        userRepository.save(user);
        logger.info("User saved with ID: {}", user.getId());

        Role userRole = roleRepository.findByName("USER");
        if (userRole != null) {
            logger.info("User role found: {}", userRole.getName());
            UserRole userRoleMapping = new UserRole();
            userRoleMapping.setUser(user);
            userRoleMapping.setRole(userRole);
            userRoleRepository.save(userRoleMapping);
            logger.info("UserRole saved with user ID: {} and role ID: {}", user.getId(), userRole.getId());
        } else {
            logger.error("USER role not found");
            return ResponsePayload.builder()
                    .message("Register failed: USER role not found")
                    .data(null)
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

        return ResponsePayload.builder()
                .message("Register success")
                .data(null)
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
