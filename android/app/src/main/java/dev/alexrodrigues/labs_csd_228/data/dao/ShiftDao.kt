package dev.alexrodrigues.labs_csd_228.data.dao

import androidx.room.*
import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity

/**
 * Data Access Object for the ShiftEntity
 */
@Dao
interface ShiftDao {
    /**
     * Get all shifts
     */
    @Query("SELECT * FROM shifts")
    suspend fun getAllShifts(): List<ShiftEntity>

    /**
     * Get shifts for a specific user
     * @param userId The ID of the user
     */
    @Query("SELECT * FROM shifts WHERE userId = :userId")
    suspend fun getShiftsForUser(userId: String): List<ShiftEntity>

    /**
     * Insert a shift
     * @param shift The shift to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShift(shift: ShiftEntity)

    /**
     * Update a shift
     * @param shift The shift to update
     */
    @Update
    suspend fun updateShift(shift: ShiftEntity)

    /**
     * Delete a shift
     * @param shift The shift to delete
     */
    @Delete
    suspend fun deleteShift(shift: ShiftEntity)
}