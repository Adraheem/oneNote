package com.oneNote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UnauthorizedExceptionHandler {

    @ExceptionHandler(value = {UnauthorizedRequestException.class})
    public ResponseEntity<Object> handleUnauthorizedRequest(UnauthorizedRequestException e){
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        UnauthorizedExceptionResponse response = new UnauthorizedExceptionResponse(e.getMessage(), status,
                ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(response, status);
    }
}
