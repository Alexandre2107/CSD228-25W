package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.Calendar
import java.time.ZoneId

/**
 * Repository class for managing calendar data
 *
 * @property shiftRepository The repository for managing shifts
 */
open class CalendarRepository(private val shiftRepository: ShiftRepository) {
    /**
     * Retrieves the calendar with shifts grouped by date
     *
     * @return The calendar with shifts grouped by date
     */
    suspend fun getCalendar(): Calendar {
        val shifts = shiftRepository.getAllShifts()
        val shiftsByDate = shifts.groupBy { shift ->
            shift.startTime.atZone(ZoneId.systemDefault()).toLocalDate()
        }
        return Calendar(shiftsByDate)
    }
}