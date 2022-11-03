package com.udacity.project4.locationreminders.data

import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.data.dto.Result

// Use FakeDataSource that acts as a test double to the LocalDataSource
class FakeDataSource(private val reminderList: MutableList<ReminderDTO> = mutableListOf()) :
    ReminderDataSource {

    private var shouldFail = false

    // sets shouldFail true/false for our repository
    fun setShouldFail(shouldFail: Boolean) {
        this.shouldFail = shouldFail
    }

    // returns Result success/error from reminders if shouldFail is false return success else error
    override suspend fun getReminders(): Result<List<ReminderDTO>> {
        if (shouldFail) {
            return Result.Error("Test Exception")
        }
        return Result.Success(reminderList.toList())
    }

    // to save reminder to our reminderList if shouldFail is false value
    override suspend fun saveReminder(reminder: ReminderDTO) {
        // add to reminderList
        reminderList.add(reminder)
    }

    // to get reminder by id from our reminderList if shouldFail is false value
    override suspend fun getReminder(id: String): Result<ReminderDTO> {
        if (shouldFail) {
            return Result.Error("Test Exception")
        }
        reminderList.find { it.id == id }?.let {
            return Result.Success(it)
        }
        return Result.Error(
            "Reminder not found"
        )
    }

    // delete our reminderList if shouldFail is false value
    override suspend fun deleteAllReminders() {
        // clear all
        reminderList.clear()
    }
}