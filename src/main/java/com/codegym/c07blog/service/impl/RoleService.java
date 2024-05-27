package com.codegym.c07blog.service.impl;

import com.codegym.c07blog.entity.authentication.Role;
import com.codegym.c07blog.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository roleRepository;

    public Role saveRole(Role role) throws Exception {
        if (role.isSuperAdmin()) {
            Role existingSuperAdminRole = roleRepository.findByIsSuperAdmin(true);
            if (existingSuperAdminRole != null && !existingSuperAdminRole.getId().equals(role.getId())) {
                throw new Exception("Only one SUPER_ADMIN role is allowed.");
            }
        }
        return roleRepository.save(role);
    }
}
