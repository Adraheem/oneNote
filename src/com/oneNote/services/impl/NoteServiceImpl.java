package com.oneNote.services.impl;

import com.oneNote.data.models.NoteEntity;
import com.oneNote.data.models.ReminderEntity;
import com.oneNote.data.models.UserEntity;
import com.oneNote.data.repositories.NoteRepository;
import com.oneNote.dto.requests.CreateNoteRequestDTO;
import com.oneNote.dto.requests.UpdateNoteRequestDTO;
import com.oneNote.dto.responses.NoteDTO;
import com.oneNote.dto.responses.Paginated;
import com.oneNote.exception.general.NoteNotFoundException;
import com.oneNote.services.NoteService;
import com.oneNote.services.ReminderService;
import com.oneNote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        if (createNoteRequestDTO.getReminder() != null) {
            ReminderEntity reminder = new ReminderEntity();
            reminder.setReminderDate(createNoteRequestDTO.getReminder());

            ReminderEntity savedReminder = reminderService.createReminder(reminder);

            newNote.setReminder(savedReminder);
        }
        UserEntity user = userService.getAuthenticatedUser();
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
        UserEntity user = userService.getAuthenticatedUser();
        Optional<NoteEntity> getNote = noteRepository.findByIdAndUser(updateNoteRequestDTO.getId(), user);
        if (getNote.isPresent()) {
            NoteEntity note = getNote.get();
            note.setTitle(updateNoteRequestDTO.getTitle());
            note.setBody(updateNoteRequestDTO.getBody());

            if (updateNoteRequestDTO.getReminder() != null) {
                if (note.getReminder() != null) {
                    ReminderEntity noteReminder = note.getReminder();
                    noteReminder.setReminderDate(updateNoteRequestDTO.getReminder().getReminderDate());

                    reminderService.updateReminder(noteReminder);
                } else {
                    ReminderEntity reminder = new ReminderEntity();
                    reminder.setReminderDate(updateNoteRequestDTO.getReminder().getReminderDate());

                    reminder = reminderService.createReminder(reminder);
                    note.setReminder(reminder);
                }
            } else {
                if (note.getReminder() != null) {
                    reminderService.deleteReminder(note.getReminder().getId());
                }
                note.setReminder(null);
            }

            NoteEntity updatedNote = noteRepository.save(note);
            return generateNoteDtoFromNoteEntity(updatedNote);
        }
        throw new NoteNotFoundException();
    }

    @Override
    public void deleteNote(Long id) {
        UserEntity user = userService.getAuthenticatedUser();
        Optional<NoteEntity> note = noteRepository.findByIdAndUser(id, user);
        if (note.isPresent()) {
            noteRepository.deleteById(id);
        } else {
            throw new NoteNotFoundException();
        }
    }

    @Override
    public Paginated<NoteDTO> getAllNotes() {
        UserEntity user = userService.getAuthenticatedUser();

        Page<NoteEntity> notes = noteRepository.findAllByUser(user, PageRequest.of(0, 20));

        Paginated<NoteDTO> result = new Paginated<>(notes);
        result.setContent(notes.getContent()
                .stream()
                .map(NoteServiceImpl::generateNoteDtoFromNoteEntity)
                .collect(Collectors.toList())
        );
        return result;
    }

    @Override
    public NoteDTO getNote(Long id) {
        UserEntity user = userService.getAuthenticatedUser();
        Optional<NoteEntity> note = noteRepository.findByIdAndUser(id, user);
        if (note.isPresent()) {
            return generateNoteDtoFromNoteEntity(note.get());
        } else {
            throw new NoteNotFoundException();
        }
    }
}
