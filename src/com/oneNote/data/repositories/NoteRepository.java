package com.oneNote.data.repositories;

import com.oneNote.data.models.NoteEntity;
import com.oneNote.data.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends PagingAndSortingRepository<NoteEntity, Long>, JpaRepository<NoteEntity, Long> {

    Optional<NoteEntity> findByIdAndUser(Long id, UserEntity user);

    Page<NoteEntity> findAllByUser(UserEntity user, Pageable pageable);

}
