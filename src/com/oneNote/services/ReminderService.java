package com.oneNote.services;

import com.oneNote.data.models.ReminderEntity;

public interface ReminderService {

    ReminderEntity createReminder(ReminderEntity reminder);

    ReminderEntity updateReminder(ReminderEntity reminder);

}
