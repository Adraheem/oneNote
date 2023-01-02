package com.oneNote.exception.general;

import com.oneNote.exception.ApiRequestException;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ApiRequestException {

    public InternalServerErrorException(){
        this("Internal Server Error");
    }

    public InternalServerErrorException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
