package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.dao.ShiftDao
import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity

/**
 * Repository for shift data
 */
class ShiftRepository(private val shiftDao: ShiftDao) {
    /**
     * Get all shifts
     */
    suspend fun getAllShifts(): List<ShiftEntity> = shiftDao.getAllShifts()

    /**
     * Insert a shift
     * @param shift The shift to insert
     */
    suspend fun insertShift(shift: ShiftEntity) = shiftDao.insertShift(shift)

    /**
     * Update a shift
     * @param shift The shift to update
     */
    suspend fun updateShift(shift: ShiftEntity) = shiftDao.updateShift(shift)

    /**
     * Get shifts for a specific user
     * @param userId The ID of the user
     */
    suspend fun getShiftsForUser(userId: String): List<ShiftEntity> = shiftDao.getShiftsForUser(userId)

    /**
     * Delete a shift
     * @param shift The shift to delete
     */
    suspend fun deleteShift(shift: ShiftEntity) = shiftDao.deleteShift(shift)

    /**
     * Get the next shift ID
     */
    suspend fun getNextShiftId(): String {
        val shifts = shiftDao.getAllShifts()
        val maxId = shifts.mapNotNull { it.id.removePrefix("shift").toIntOrNull() }.maxOrNull() ?: 0
        return "shift${maxId + 1}"
    }
}