package com.oneNote.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApiRequestException {

    public UserNotFoundException(){
        this("User not found");
    }

    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
