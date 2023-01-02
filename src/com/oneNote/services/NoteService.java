package com.oneNote.services;

import com.oneNote.dto.requests.CreateNoteRequestDTO;
import com.oneNote.dto.requests.UpdateNoteRequestDTO;
import com.oneNote.dto.responses.NoteDTO;

import java.util.List;

public interface NoteService {

    NoteDTO createNote(CreateNoteRequestDTO createNoteRequestDTO);

    NoteDTO updateNote(UpdateNoteRequestDTO updateNoteRequestDTO);

    void deleteNote(Long id);

    List<NoteDTO> getAllNotes();

    NoteDTO getNote(Long id);

}
