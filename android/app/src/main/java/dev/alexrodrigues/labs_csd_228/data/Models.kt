package dev.alexrodrigues.labs_csd_228.data

import java.time.Instant
import java.time.LocalDate

/**
 * Data class representing a User.
 *
 * @property id The ID of the user
 * @property name The name of the user
 * @property email The email address of the user
 * @property phone The phone number of the user
 * @property accessibilityRequirements A list of accessibility requirements for the user
 */
data class User(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val accessibilityRequirements: List<String>
)

/**
 * Data class representing a Shift.
 *
 * @property id The ID of the shift
 * @property userId The ID of the user associated with the shift
 * @property startTime The start time of the shift
 * @property endTime The end time of the shift
 * @property location The location of the shift
 * @property description A description of the shift
 */
data class Shift(
    val id: String,
    val userId: String,
    val startTime: Instant,
    val endTime: Instant,
    var location: String,
    val description: String
)

/**
 * Data class representing a Calendar.
 *
 * @property shiftsByDate A map of shifts grouped by date
 */
data class Calendar(
    val shiftsByDate: Map<LocalDate, List<Shift>>
)

/**
 * Data class representing the app settings.
 *
 * @property darkMode A boolean indicating if dark mode is enabled or not
 */
data class Settings(
    val darkMode: Boolean,
) {
    companion object {
        val DEFAULT = Settings(darkMode = false)
    }
}