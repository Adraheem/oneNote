package com.oneNote.services;

import com.oneNote.dto.requests.CreateNoteRequestDTO;
import com.oneNote.dto.requests.UpdateNoteRequestDTO;
import com.oneNote.dto.responses.NoteDTO;
import com.oneNote.dto.responses.Paginated;

public interface NoteService {

    NoteDTO createNote(CreateNoteRequestDTO createNoteRequestDTO);

    NoteDTO updateNote(UpdateNoteRequestDTO updateNoteRequestDTO);

    void deleteNote(Long id);

    Paginated<NoteDTO> getAllNotes();

    NoteDTO getNote(Long id);

}
