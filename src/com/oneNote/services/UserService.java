package com.oneNote.services;

import com.oneNote.data.models.UserEntity;
import com.oneNote.dto.requests.LoginRequestDTO;
import com.oneNote.dto.requests.SignUpRequestDTO;
import com.oneNote.dto.responses.LoginResponseDTO;

public interface UserService {

    String createNewUser(SignUpRequestDTO signUpRequestDTO);
    LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO);

    UserEntity getAuthenticatedUser();
}
