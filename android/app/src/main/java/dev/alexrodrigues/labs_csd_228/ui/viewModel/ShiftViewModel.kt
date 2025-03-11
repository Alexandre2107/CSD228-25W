package dev.alexrodrigues.labs_csd_228.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alexrodrigues.labs_csd_228.data.Shift
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for managing shift data
 *
 * @property shiftRepository The repository that provides shift data
 */
class ShiftViewModel(private val shiftRepository: ShiftRepository) : ViewModel() {
    // MutableStateFlow to hold the list of shifts
    private val _shifts = MutableStateFlow<List<Shift>>(emptyList())
    val shifts: StateFlow<List<Shift>> = _shifts

    init {
        // Initialize the ViewModel by loading all shifts
        viewModelScope.launch {
            _shifts.emit(shiftRepository.getAllShifts())
        }
    }

    /**
     * Updates a shift with new values
     *
     * @param shift The shift to be updated
     */
    fun updateShift(shift: Shift) {
        viewModelScope.launch {
            shiftRepository.updateShift(shift)
            _shifts.emit(shiftRepository.getAllShifts())
        }
    }
}