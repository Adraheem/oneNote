package com.oneNote.controllers;

import com.oneNote.data.models.User;
import com.oneNote.dto.requests.LoginRequestDTO;
import com.oneNote.dto.requests.SignUpRequestDTO;
import com.oneNote.dto.responses.LoginResponseDTO;
import com.oneNote.exception.ApiRequestException;
import com.oneNote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginRequestDTO loginRequestDTO) {
        return userService.loginUser(loginRequestDTO);
    }

    @PostMapping("/register")
    public String signup(@RequestBody SignUpRequestDTO signupRequestDTO) {
        User user = userService.createNewUser(signupRequestDTO);
        if (user != null){
            return "Signed up successfully";
        }
        throw new ApiRequestException("An error occurred");
    }
}
