package com.oneNote.exception.general;

import com.oneNote.exception.ApiRequestException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiRequestException {

    public BadRequestException(){
        this("Bad Request");
    }

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
