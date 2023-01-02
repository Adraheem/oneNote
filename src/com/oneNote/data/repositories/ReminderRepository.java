package com.oneNote.data.repositories;

import com.oneNote.data.models.ReminderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderEntity, Long> {
}
