package dev.alexrodrigues.labs_csd_228.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alexrodrigues.labs_csd_228.data.entities.UserEntity
import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for user data
 * @param userRepository The repository to handle user data
 * @param shiftRepository The repository to handle shift data
 */
class UserViewModel(
    private val userRepository: UserRepository,
    private val shiftRepository: ShiftRepository
) : ViewModel() {
    // StateFlow to hold the list of users
    private val _users = MutableStateFlow<List<UserEntity>>(emptyList())
    val users: StateFlow<List<UserEntity>> = _users

    init {
        fetchAllUsers()
    }

    // Fetch all users from the repository
    fun fetchAllUsers() {
        viewModelScope.launch {
            _users.value = userRepository.getAllUsers()
        }
    }

    /**
     * Insert a user
     * @param user The user to insert
     */
    fun insertUser(user: UserEntity) {
        viewModelScope.launch {
            val userId = userRepository.getNextUserId()
            val newUser = user.copy(id = userId)
            userRepository.insertUser(newUser)
            fetchAllUsers() // Refresh the list after insertion
        }
    }

    /**
     * Get shifts for a specific user
     * @param userId The ID of the user
     */
    suspend fun getShiftsForUser(userId: String): List<ShiftEntity> {
        return shiftRepository.getShiftsForUser(userId)
    }

    /**
     * Delete a user
     * @param user The user to delete
     */
    fun deleteUser(user: UserEntity) {
        viewModelScope.launch {
            userRepository.deleteUser(user)
            fetchAllUsers() // Refresh the list after deletion
        }
    }
}