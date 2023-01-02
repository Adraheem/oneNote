package com.oneNote.services.impl;

import com.oneNote.data.models.NoteEntity;
import com.oneNote.data.models.ReminderEntity;
import com.oneNote.data.models.UserEntity;
import com.oneNote.data.repositories.NoteRepository;
import com.oneNote.dto.requests.CreateNoteRequestDTO;
import com.oneNote.dto.requests.UpdateNoteRequestDTO;
import com.oneNote.dto.responses.NoteDTO;
import com.oneNote.exception.general.NoteNotFoundException;
import com.oneNote.services.NoteService;
import com.oneNote.services.ReminderService;
import com.oneNote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;
    private UserService userService;
    private ReminderService reminderService;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, UserService userService, ReminderService reminderService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
        this.reminderService = reminderService;
    }

    @Override
    public NoteDTO createNote(CreateNoteRequestDTO createNoteRequestDTO) {
        NoteEntity newNote = new NoteEntity();
        newNote.setTitle(createNoteRequestDTO.getTitle());
        newNote.setBody(createNoteRequestDTO.getBody());

        if(createNoteRequestDTO.getReminder() != null){
            ReminderEntity reminder = new ReminderEntity();
            reminder.setReminderDate(createNoteRequestDTO.getReminder());

            ReminderEntity savedReminder = reminderService.createReminder(reminder);

            newNote.setReminder(savedReminder);
        }
        UserEntity user = userService.getUser();
        newNote.setUser(user);

        NoteEntity savedNote = noteRepository.save(newNote);

        return generateNoteDtoFromNoteEntity(savedNote);
    }

    private static NoteDTO generateNoteDtoFromNoteEntity(NoteEntity savedNote) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(savedNote.getId());
        noteDTO.setTitle(savedNote.getTitle());
        noteDTO.setBody(savedNote.getBody());
        noteDTO.setDateCreated(savedNote.getDateCreated());
        noteDTO.setDateUpdated(savedNote.getDateUpdated());
        noteDTO.setReminder(savedNote.getReminder());
        return noteDTO;
    }

    @Override
    public NoteDTO updateNote(UpdateNoteRequestDTO updateNoteRequestDTO) {
        return null;
    }

    @Override
    public void deleteNote(Long id) {
        if (noteRepository.findById(id).isPresent()) {
            noteRepository.deleteById(id);
        } else {
            throw new NoteNotFoundException();
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return null;
    }

    @Override
    public NoteDTO getNote(Long id) {
        return null;
    }
}
