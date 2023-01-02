package com.oneNote.dto.responses;

import com.oneNote.data.models.ReminderEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteDTO {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private ReminderEntity reminder;
}
