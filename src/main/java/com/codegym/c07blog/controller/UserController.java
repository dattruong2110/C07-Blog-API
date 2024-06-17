package com.codegym.c07blog.controller;

import com.codegym.c07blog.dto.UserDTO;
import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.payload.request.UserRequest;
import com.codegym.c07blog.payload.response.ResponsePayload;
import com.codegym.c07blog.payload.response.UserResponse;
import com.codegym.c07blog.service.IUserService;
import com.fasterxml.jackson.core.util.RequestPayload;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final IUserService userService;

    @Transactional
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users.stream().filter(user -> !user.getIsDeleted()).collect(Collectors.toList()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RequestPayload> delete(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        userService.delete(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RequestPayload> update(@RequestBody UserRequest userRequest) {
        ResponsePayload responsePayload = userService.update(userRequest);
        return new ResponseEntity<>(responsePayload.getStatus());
    }

    @GetMapping("/check-username")
    public ResponseEntity<Boolean> checkUsername(@RequestParam String username) {
        boolean exists = userService.existsByUsername(username);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        boolean exists = userService.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/admin/{id}")
    public ResponseEntity<?> createAdminAccount(@RequestBody UserRequest userRequest, @PathVariable("id") UUID superAdminId) {
        try {
            UserResponse createdUser = userService.createAdminAccount(userRequest, superAdminId);
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getBlogByUserID(@PathVariable UUID id) {
        UserDTO userDTO = userService.getBlogByUserID(id);

        if (userDTO != null) {
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/fact/{id}")
    public ResponseEntity<UserDTO> getFactByUserID(@PathVariable UUID id) {
        UserDTO userDTO = userService.getFactByUserID(id);

        if (userDTO != null) {
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
