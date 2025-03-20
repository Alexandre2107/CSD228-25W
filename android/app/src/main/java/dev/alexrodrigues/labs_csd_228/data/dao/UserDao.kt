package dev.alexrodrigues.labs_csd_228.data.dao

import androidx.room.*
import dev.alexrodrigues.labs_csd_228.data.entities.UserEntity

/**
 * Data Access Object for the UserEntity.
 */
@Dao
interface UserDao {
    /**
     * Get all users
     */
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    /**
     * Insert a user
     * @param user The user to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    /**
     * Update a user
     * @param user The user to update
     */
    @Update
    suspend fun updateUser(user: UserEntity)

    /**
     * Delete a user
     * @param user The user to delete
     */
    @Delete
    suspend fun deleteUser(user: UserEntity)
}