package com.oneNote.dto.requests;

import lombok.Data;

@Data
public class SignUpRequestDTO {
    private String fullName;
    private String username;
    private String password;
}
