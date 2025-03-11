package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.Shift
import kotlinx.coroutines.coroutineScope
import java.time.Instant
import java.time.Duration

/**
 * Repository class for managing shifts
 */
class ShiftRepository {
    private val shifts = mutableListOf(
        Shift(
            id = "shift1",
            userId = "user1",
            startTime = Instant.now(),
            endTime = Instant.now().plus(Duration.ofDays(1) + Duration.ofHours(8)),
            location = "Office",
            description = "Morning Shift"
        ),
        Shift(
            id = "shift2",
            userId = "user2",
            startTime = Instant.now().plus(Duration.ofDays(1)),
            endTime = Instant.now().plus(Duration.ofDays(2) + Duration.ofHours(8)),
            location = "Remote",
            description = "Remote Work"
        )
    )

    /**
     * Retrieves all shifts
     *
     * @return A list of all shifts
     */
    suspend fun getAllShifts(): List<Shift> = coroutineScope { shifts }

    /**
     * Retrieves upcoming shifts
     *
     * @return A list of upcoming shifts
     */
    suspend fun getUpcomingShifts(): List<Shift> = coroutineScope {
        shifts.filter { it.startTime > Instant.now() }
    }

    /**
     * Updates a shift
     *
     * @param shift The shift to update
     */
    suspend fun updateShift(shift: Shift): Unit  = coroutineScope {
        val index = shifts.indexOfFirst { it.id == shift.id }
        if (index != -1) {
            shifts[index] = shift
        }
    }
}