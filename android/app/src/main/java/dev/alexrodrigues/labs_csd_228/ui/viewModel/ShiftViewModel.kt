package dev.alexrodrigues.labs_csd_228.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for shift data
 * @param shiftRepository The repository to handle shift data
 */
class ShiftViewModel(private val shiftRepository: ShiftRepository) : ViewModel() {
    // StateFlow to hold the list of shifts
    private val _shifts = MutableStateFlow<List<ShiftEntity>>(emptyList())
    val shifts: StateFlow<List<ShiftEntity>> = _shifts

    init {
        fetchAllShifts()
    }

    // Fetch all shifts from the repository
    fun fetchAllShifts() {
        viewModelScope.launch {
            _shifts.value = shiftRepository.getAllShifts()
        }
    }

    /**
     * Insert a shift
     * @param shift The shift to insert
     */
    fun insertShift(shift: ShiftEntity) {
        viewModelScope.launch {
            val shiftId = shiftRepository.getNextShiftId()
            val newShift = shift.copy(id = shiftId)
            shiftRepository.insertShift(newShift)
            fetchAllShifts() // Refresh the list after insertion
        }
    }

    /**
     * Delete a shift
     * @param shift The shift to delete
     */
    fun deleteShift(shift: ShiftEntity) {
        viewModelScope.launch {
            shiftRepository.deleteShift(shift)
            fetchAllShifts() // Refresh the list after deletion
        }
    }
}