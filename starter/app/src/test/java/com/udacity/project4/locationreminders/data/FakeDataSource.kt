package com.udacity.project4.locationreminders.data

import com.udacity.project4.locationreminders.data.dto.ReminderDTO
import com.udacity.project4.locationreminders.data.dto.Result

// Use FakeDataSource that acts as a test double to the LocalDataSource
class FakeDataSource : ReminderDataSource {

    private var shouldFail = false

    // Create a fake data source to act as a double to the real data source
    var reminderList = mutableListOf<ReminderDTO>()

    // sets shouldFail true/false for our repository
    fun setShouldFail(shouldFail: Boolean) {
        this.shouldFail = shouldFail
    }

    // returns Result success/error from reminders if shouldFail is false return success else error
    override suspend fun getReminders(): Result<List<ReminderDTO>> {
        return try {
            if (shouldFail) throw Exception("Error getting reminders")
            // returns success reminderList
            Result.Success(reminderList)
        } catch (e: Exception) {
            // get back error
            Result.Error(e.message)
        }
    }

    // to save reminder to our reminderList if shouldFail is false value
    override suspend fun saveReminder(reminder: ReminderDTO) {
        if (shouldFail) throw Exception("Error saving reminder")
        // add to reminderList
        reminderList.add(reminder)
    }

    // to get reminder by id from our reminderList if shouldFail is false value
    override suspend fun getReminder(id: String): Result<ReminderDTO> {
        if (shouldFail) throw Exception("Error getting reminder")
        // get first reminder by id
        return Result.Success(reminderList.first { it.id == id })
    }

    // delete our reminderList if shouldFail is false value
    override suspend fun deleteAllReminders() {
        if (shouldFail) throw Exception("Error deleting reminders")
        // clear all
        reminderList.clear()
    }
}