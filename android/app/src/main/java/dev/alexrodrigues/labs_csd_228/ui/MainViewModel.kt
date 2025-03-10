package dev.alexrodrigues.labs_csd_228.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alexrodrigues.labs_csd_228.data.User
import dev.alexrodrigues.labs_csd_228.data.repository.CalendarRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.data.Calendar
import dev.alexrodrigues.labs_csd_228.data.Shift
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for managing UI-related data in the main screen
 *
 * @property userRepository Repository for managing user data
 * @property shiftRepository Repository for managing shift data
 * @property calendarRepository Repository for managing calendar data
 */
class MainViewModel(
    private val userRepository: UserRepository,
    private val shiftRepository: ShiftRepository,
    private val calendarRepository: CalendarRepository
) : ViewModel() {

    // Mutable state flow for user data
    private val _user = MutableStateFlow<User?>(null)
    // State flow for user data
    val user: StateFlow<User?> = _user

    // Mutable state flow for shift data
    private val _shifts = MutableStateFlow<List<Shift>>(emptyList())
    // State flow for shift data
    val shifts: StateFlow<List<Shift>> = _shifts

    // Mutable state flow for calendar data
    private val _calendar = MutableStateFlow<Calendar?>(null)
    // State flow for calendar data
    val calendar: StateFlow<Calendar?> = _calendar

    // Initialization block to load initial data
    init {
        viewModelScope.launch {
            _user.value = userRepository.getUser()
            _shifts.value = shiftRepository.getAllShifts()
            _calendar.value = calendarRepository.getCalendar()
        }
    }

    /**
     * Updates the user data
     *
     * @param user The user data to update
     */
    fun updateUser(user: User) {
        viewModelScope.launch {
            userRepository.updateUser(
                name = user.name,
                email = user.email,
                phone = user.phone,
                accessibilityRequirements = user.accessibilityRequirements
            )
            _user.value = user
        }
    }

    /**
     * Updates the shift data
     *
     * @param shift The shift data to update
     */
    fun updateShift(shift: Shift) {
        viewModelScope.launch {
            shiftRepository.updateShift(shift)
            _shifts.value = shiftRepository.getAllShifts()
            _calendar.value = calendarRepository.getCalendar()
        }
    }

    fun init() {
        viewModelScope.launch {
            _user.value = userRepository.getUser()
        }
    }
}