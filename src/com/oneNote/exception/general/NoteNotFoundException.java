package com.oneNote.exception.general;

import com.oneNote.exception.ApiRequestException;
import org.springframework.http.HttpStatus;

public class NoteNotFoundException extends ApiRequestException {
    public NoteNotFoundException() {
        this("Note not found!");
    }

    public NoteNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
