package com.oneNote.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
public class AuthenticatedUser implements UserDetails {

    @NonNull
    private Long id;

    @NonNull
    private String fullName;

    @NonNull
    private final String username;

    @NonNull
    private String password;

    @NonNull
    private final Collection<GrantedAuthority> authorities;

    private final boolean accountNonExpired = true;

    private final boolean accountNonLocked = true;

    private final boolean credentialsNonExpired = true;

    private final boolean enabled = true;

}
