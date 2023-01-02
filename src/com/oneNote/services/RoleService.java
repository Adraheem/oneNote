package com.oneNote.services;

import com.oneNote.data.models.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> getRole(String role);

    Role createRole(String role);

}
