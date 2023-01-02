package com.oneNote.exception.general;

import com.oneNote.exception.ApiRequestException;
import org.springframework.http.HttpStatus;

public class UnauthorizedRequestException extends ApiRequestException {
    public UnauthorizedRequestException() {
        this("Unauthorized request");
    }

    public UnauthorizedRequestException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
