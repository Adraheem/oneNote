package com.oneNote.dto.requests;

import lombok.Data;

@Data
public class GetAllNotesRequestDTO {

    private int page;
    private int size;

}
