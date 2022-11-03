package com.udacity.project4.locationreminders.utils

import com.udacity.project4.locationreminders.data.dto.ReminderDTO

object Utils {
    fun buildReminderData(): MutableList<ReminderDTO> {
        return mutableListOf(
            ReminderDTO(
                "title",
                "Description", "Location", 18.743646142139145,
                -33.955688815535005
            ),
            ReminderDTO(
                "title",
                "Description", "Location", 18.743646142139145,
                -33.955688815535005

            ),
            ReminderDTO(
                "title",
                "Description", "Location", 18.743646142139145,
                -33.955688815535005
            ),
            ReminderDTO(
                "title",
                "Description", "Location", 18.743646142139145,
                -33.955688815535005
            )
        )
    }
}