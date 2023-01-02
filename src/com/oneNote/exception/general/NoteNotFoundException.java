package com.oneNote.exception.general;

import com.oneNote.exception.ApiRequestException;

public class NoteNotFoundException extends ApiRequestException {
    public NoteNotFoundException() {
        this("Note not found!");
    }

    public NoteNotFoundException(String message) {
        super(message);
    }
}
