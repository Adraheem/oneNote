package com.oneNote.exception;

public class UnauthorizedRequestException extends RuntimeException {
    public UnauthorizedRequestException() {
        this("Unauthorized");
    }

    public UnauthorizedRequestException(String message) {
        super(message);
    }
}
