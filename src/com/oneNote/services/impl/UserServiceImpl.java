package com.oneNote.services.impl;

import com.oneNote.data.models.Role;
import com.oneNote.data.models.UserEntity;
import com.oneNote.data.repositories.UserRepository;
import com.oneNote.dto.requests.LoginRequestDTO;
import com.oneNote.dto.requests.SignUpRequestDTO;
import com.oneNote.dto.responses.LoginResponseDTO;
import com.oneNote.exception.general.BadRequestException;
import com.oneNote.exception.general.UnauthorizedRequestException;
import com.oneNote.security.JwtGenerator;
import com.oneNote.services.RoleService;
import com.oneNote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleService roleService;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private JwtGenerator tokenGenerator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService,
                           AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                           JwtGenerator tokenGenerator) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public String createNewUser(SignUpRequestDTO signUpRequestDTO) {
        if (userRepository.existsByUsername(signUpRequestDTO.getUsername())) {
            throw new BadRequestException("Email already used");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(signUpRequestDTO.getUsername());
        userEntity.setFullName(signUpRequestDTO.getFullName());
        userEntity.setPassword(passwordEncoder.encode(signUpRequestDTO.getPassword()));

        Optional<Role> role = roleService.getRole("USER");
        role.ifPresent(value -> userEntity.setRoles(Collections.singletonList(value)));

        userRepository.save(userEntity);

        return "Account created successfully";

    }

    @Override
    public LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenGenerator.generateToken(authentication);

        LoginResponseDTO response = new LoginResponseDTO("Bearer " + token);
        return response;
    }
}
