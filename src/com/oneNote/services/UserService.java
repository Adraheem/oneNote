package com.oneNote.services;

import com.oneNote.dto.requests.LoginRequestDTO;
import com.oneNote.dto.requests.SignUpRequestDTO;
import com.oneNote.dto.responses.LoginResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    String createNewUser(SignUpRequestDTO signUpRequestDTO);
    LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO);

}
