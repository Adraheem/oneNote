package com.oneNote.data.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateUpdated = LocalDateTime.now();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ReminderEntity reminder;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity user;

}
