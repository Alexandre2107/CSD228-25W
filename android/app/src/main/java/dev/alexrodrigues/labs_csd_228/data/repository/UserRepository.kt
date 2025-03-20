package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.dao.UserDao
import dev.alexrodrigues.labs_csd_228.data.entities.UserEntity

/**
 * Repository for user data
 */
class UserRepository(private val userDao: UserDao) {
    /**
     * Get all users
     */
    suspend fun getAllUsers(): List<UserEntity> = userDao.getAllUsers()

    /**
     * Insert a user
     * @param user The user to insert
     */
    suspend fun insertUser(user: UserEntity) = userDao.insertUser(user)

    /**
     * Update a user
     * @param user The user to update
     */
    suspend fun updateUser(user: UserEntity) = userDao.updateUser(user)

    /**
     * Delete a user
     * @param user The user to delete
     */
    suspend fun deleteUser(user: UserEntity) = userDao.deleteUser(user)

    /**
     * Get the next user ID
     */
    suspend fun getNextUserId(): String {
        val users = userDao.getAllUsers()
        val maxId = users.mapNotNull { it.id.removePrefix("user").toIntOrNull() }.maxOrNull() ?: 0
        return "user${maxId + 1}"
    }
}