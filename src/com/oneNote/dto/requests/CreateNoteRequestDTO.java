package com.oneNote.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteRequestDTO {

    private String title;
    private String body;
    private LocalDateTime reminder;

}
