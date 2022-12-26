package com.oneNote.services.impl;

import com.oneNote.data.models.User;
import com.oneNote.data.repositories.UserRepository;
import com.oneNote.dto.requests.LoginRequestDTO;
import com.oneNote.dto.requests.SignUpRequestDTO;
import com.oneNote.dto.responses.LoginResponseDTO;
import com.oneNote.exception.ApiRequestException;
import com.oneNote.exception.UnauthorizedRequestException;
import com.oneNote.exception.UserNotFoundException;
import com.oneNote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createNewUser(SignUpRequestDTO signUpRequestDTO) {
        if (userRepository.findByEmail(signUpRequestDTO.getEmail()).isPresent()) {
            throw new ApiRequestException("Email already used");
        }
        User user = new User();
        user.setEmail(signUpRequestDTO.getEmail());
        user.setFullName(signUpRequestDTO.getFullName());
        user.setPassword(signUpRequestDTO.getPassword());

        return userRepository.save(user);
    }

    @Override
    public LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO) {
        Optional<User> user = userRepository.findByEmail(loginRequestDTO.getEmail());
        if (user.isPresent()){
            User foundUser = user.get();
            LoginResponseDTO response = new LoginResponseDTO();
            response.setToken(foundUser.getFullName());
            return response;
        }
        throw new UnauthorizedRequestException("Incorrect details");
    }
}
