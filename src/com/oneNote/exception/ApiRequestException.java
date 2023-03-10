package com.oneNote.exception;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException {
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
