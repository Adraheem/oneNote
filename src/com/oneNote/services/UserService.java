package com.oneNote.services;

import com.oneNote.data.models.User;
import com.oneNote.dto.requests.LoginRequestDTO;
import com.oneNote.dto.requests.SignUpRequestDTO;
import com.oneNote.dto.responses.LoginResponseDTO;

public interface UserService {
    User createNewUser(SignUpRequestDTO signUpRequestDTO);
    LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO);
}
