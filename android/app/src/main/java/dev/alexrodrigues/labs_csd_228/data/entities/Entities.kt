package dev.alexrodrigues.labs_csd_228.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity class for users
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val accessibilityRequirements: String
)

/**
 * Entity class for shifts
 */
@Entity(tableName = "shifts")
data class ShiftEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val startTime: Long,
    val endTime: Long,
    val location: String,
    val description: String
)