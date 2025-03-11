package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.User
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Repository class for managing user data
 */
class UserRepository {
    private val user = mutableListOf(
        User(
            id = "user1",
            name = "John Doe",
            email = "john@example.com",
            phone = "123-456-7890",
            accessibilityRequirements = listOf("High Contrast", "Screen Reader")
        ),
        User(
            id = "user2",
            name = "Jane Smith",
            email = "jane@example.com",
            phone = "987-654-3210",
            accessibilityRequirements = listOf("Large Text", "Voice Control")
        )
    )

    private var currentUserIndex = 0

    /**
     * Retrieves the current user
     *
     * @return The current user
     */
    suspend fun getUser(): User = user[currentUserIndex]

    /**
     * Retrieves all users
     *
     * @return The list of all users
     */
    suspend fun getAllUsers(): List<User> = user

    /**
     * Updates the current user
     *
     * @param name The new name of the user
     * @param email The new email address of the user
     * @param phone The new phone number of the user
     * @param accessibilityRequirements The new accessibility requirements of the user
     */
    suspend fun updateUser(
        name: String? = null,
        email: String? = null,
        phone: String? = null,
        accessibilityRequirements: List<String>? = null
    ) {
        val currentUser = user[currentUserIndex]
        user[currentUserIndex] = currentUser.copy(
            name = name ?: currentUser.name,
            email = email ?: currentUser.email,
            phone = phone ?: currentUser.phone,
            accessibilityRequirements = accessibilityRequirements ?: currentUser.accessibilityRequirements
        )
    }
}