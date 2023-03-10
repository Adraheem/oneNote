package com.oneNote.controllers;

import com.oneNote.dto.requests.LoginRequestDTO;
import com.oneNote.dto.requests.SignUpRequestDTO;
import com.oneNote.dto.responses.LoginResponseDTO;
import com.oneNote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO res = userService.loginUser(loginRequestDTO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> signup(@AuthenticationPrincipal  Authentication authentication,
                                         @RequestBody SignUpRequestDTO signupRequestDTO) {

        return new ResponseEntity<>(userService.createNewUser(signupRequestDTO), HttpStatus.OK);
    }
}
