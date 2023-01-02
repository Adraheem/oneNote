package com.oneNote.controllers;

import com.oneNote.dto.requests.CreateNoteRequestDTO;
import com.oneNote.dto.responses.NoteDTO;
import com.oneNote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/note")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping(value = "")
    public ResponseEntity<NoteDTO> createNewNote(@RequestBody CreateNoteRequestDTO createNoteRequest){
        NoteDTO res = noteService.createNote(createNoteRequest);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
