package dev.alexrodrigues.labs_csd_228.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.alexrodrigues.labs_csd_228.data.repository.CalendarRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository

/**
 * Factory class for creating instances of MainViewModel.
 *
 * @property userRepository Repository for managing user data
 * @property shiftRepository Repository for managing shift data
 * @property calendarRepository Repository for managing calendar data
 */
class MainViewModelFactory(
    private val userRepository: UserRepository,
    private val shiftRepository: ShiftRepository,
    private val calendarRepository: CalendarRepository
) : ViewModelProvider.Factory {
    /**
     * Creates a new instance of the given ViewModel class
     *
     * @param modelClass The class of the ViewModel to create
     * @return A new instance of the ViewModel
     * @throws IllegalArgumentException if the modelClass is not assignable from MainViewModel
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(userRepository, shiftRepository, calendarRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}