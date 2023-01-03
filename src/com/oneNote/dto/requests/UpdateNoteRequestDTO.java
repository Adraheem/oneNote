package com.oneNote.dto.requests;

import lombok.Data;

@Data
public class UpdateNoteRequestDTO {

    private Long id;
    private String title;
    private String body;
    private ReminderDTO reminder;

}
