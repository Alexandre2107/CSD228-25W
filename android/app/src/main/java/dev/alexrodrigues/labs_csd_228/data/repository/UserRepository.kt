package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.User

/**
 * Repository class for managing user data
 */
open class UserRepository {
    private var currentUser = User(
        id = "user1",
        name = "John Doe",
        email = "john@example.com",
        phone = "123-456-7890",
        accessibilityRequirements = listOf("High Contrast", "Screen Reader")
    )

    /**
     * Retrieves the current user
     *
     * @return The current user
     */
    open suspend fun getUser(): User = currentUser

    /**
     * Updates the current user
     *
     * @param name The new name of the user
     * @param email The new email address of the user
     * @param phone The new phone number of the user
     * @param accessibilityRequirements The new accessibility requirements of the user
     */
    open suspend fun updateUser(
        name: String? = null,
        email: String? = null,
        phone: String? = null,
        accessibilityRequirements: List<String>? = null
    ) {
        currentUser = currentUser.copy(
            name = name ?: currentUser.name,
            email = email ?: currentUser.email,
            phone = phone ?: currentUser.phone,
            accessibilityRequirements = accessibilityRequirements ?: currentUser.accessibilityRequirements
        )
    }
}