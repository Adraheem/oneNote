package com.oneNote.controllers;

import com.oneNote.data.models.NoteEntity;
import com.oneNote.dto.requests.CreateNoteRequestDTO;
import com.oneNote.dto.requests.GetAllNotesRequestDTO;
import com.oneNote.dto.requests.UpdateNoteRequestDTO;
import com.oneNote.dto.responses.NoteDTO;
import com.oneNote.dto.responses.Paginated;
import com.oneNote.services.NoteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/note")
@Api(value = "Note Resources")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping(path = "")
    public ResponseEntity<NoteDTO> createNewNote(@RequestBody CreateNoteRequestDTO createNoteRequest) {
        NoteDTO res = noteService.createNote(createNoteRequest);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<Paginated<NoteDTO>> getAllNotes() {
        Paginated<NoteDTO> res = noteService.getAllNotes();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<NoteDTO> getNote(@PathVariable long id) {
        NoteDTO res = noteService.getNote(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping(path = "")
    public ResponseEntity<NoteDTO> updateNote(@RequestBody UpdateNoteRequestDTO updateNoteRequest) {
        NoteDTO res = noteService.updateNote(updateNoteRequest);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>("Deleted successfully!", HttpStatus.OK);
    }
}
