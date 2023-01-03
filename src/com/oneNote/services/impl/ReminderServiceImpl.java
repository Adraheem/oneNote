package com.oneNote.services.impl;

import com.oneNote.data.models.ReminderEntity;
import com.oneNote.data.repositories.ReminderRepository;
import com.oneNote.services.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl implements ReminderService {

    private ReminderRepository reminderRepository;

    @Autowired
    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public ReminderEntity createReminder(ReminderEntity reminder) {
        return reminderRepository.save(reminder);
    }

    @Override
    public ReminderEntity updateReminder(ReminderEntity reminder) {
        return reminderRepository.save(reminder);
    }

    @Override
    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }
}
