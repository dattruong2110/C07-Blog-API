package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.entity.authentication.Role;
import com.codegym.c07blog.entity.authentication.User;
import com.codegym.c07blog.entity.authentication.UserRole;
import com.codegym.c07blog.repository.IRoleRepository;
import com.codegym.c07blog.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IUserRepository userRepository;

    public Role saveRole(Role role) throws Exception {
        if (role.isSuperAdmin()) {
            Role existingSuperAdminRole = roleRepository.findByIsSuperAdmin(true);
            if (existingSuperAdminRole != null && !existingSuperAdminRole.getId().equals(role.getId())) {
                throw new Exception("Only one SUPER_ADMIN role is allowed.");
            }
        }
        return roleRepository.save(role);
    }

    public boolean isUserSuperAdmin(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        for (UserRole userRole : user.getUserRole()) {
            if (userRole.getRole().isSuperAdmin()) {
                return true;
            }
        }
        return false;
    }
}
