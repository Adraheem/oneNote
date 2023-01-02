package com.oneNote.services.impl;

import com.oneNote.data.models.Role;
import com.oneNote.data.repositories.RoleRepository;
import com.oneNote.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRole(String role) {
        return roleRepository.findByName(role);
    }

    @Override
    public Role createRole(String role) {
        if (roleRepository.existsByName(role) && roleRepository.findByName(role).isPresent()) {
            return roleRepository.findByName(role).get();
        }
        Role newRole = new Role();
        newRole.setName(role);
        return roleRepository.save(newRole);
    }
}
