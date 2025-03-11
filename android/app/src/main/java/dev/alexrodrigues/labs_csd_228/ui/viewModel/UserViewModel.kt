package dev.alexrodrigues.labs_csd_228.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alexrodrigues.labs_csd_228.data.Shift
import dev.alexrodrigues.labs_csd_228.data.User
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * ViewModel for managing user data
 *
 * @property userRepository The repository that provides user data
 * @property shiftRepository The repository that provides shift data
 */
class UserViewModel(private val userRepository: UserRepository, private val shiftRepository: ShiftRepository) : ViewModel() {
    // MutableStateFlow to hold the list of users
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        // Initialize the ViewModel by loading all users
        viewModelScope.launch {
            _users.emit(userRepository.getAllUsers())
        }
    }

    /**
     * Updates a user with new values
     *
     * @param user The user to be updated
     */
    fun updateUser(user: User) {
        viewModelScope.launch {
            userRepository.updateUser(
                name = user.name,
                email = user.email,
                phone = user.phone,
                accessibilityRequirements = user.accessibilityRequirements
            )
            _users.emit(userRepository.getAllUsers())
        }
    }

    /**
     * Retrieves the shifts for a specific user
     *
     * @param userId The ID of the user whose shifts are to be retrieved
     * @return A list of shifts for the specified user
     */
    fun getShiftsForUser(userId: String): List<Shift> = runBlocking {
        shiftRepository.getAllShifts().filter { it.userId == userId }
    }
}