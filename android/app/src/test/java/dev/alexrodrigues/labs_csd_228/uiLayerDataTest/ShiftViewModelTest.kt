/*
package dev.alexrodrigues.labs_csd_228.uiLayerDataTest

import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class ShiftViewModelTest {

    private lateinit var viewModel: ShiftViewModel
    private lateinit var shiftRepository: ShiftRepository

    @Before
    fun setUp() {
        shiftRepository = mock(ShiftRepository::class.java)
        viewModel = ShiftViewModel(shiftRepository)
    }

    @Test
    fun testInsertShift() = runBlocking {
        val shift = ShiftEntity("shift1", "user1", 0L, 3600L, "Office", "Morning Shift")
        viewModel.insertShift(shift)
        verify(shiftRepository).insertShift(any(ShiftEntity::class.java))
    }

    @Test
    fun testDeleteShift() = runBlocking {
        val shift = ShiftEntity("shift1", "user1", 0L, 3600L, "Office", "Morning Shift")
        viewModel.deleteShift(shift)
        verify(shiftRepository).deleteShift(shift)
    }

    @Test
    fun testFetchAllShifts() = runBlocking {
        val shifts = listOf(ShiftEntity("shift1", "user1", 0L, 3600L, "Office", "Morning Shift"))
        `when`(shiftRepository.getAllShifts()).thenReturn(shifts)
        viewModel.fetchAllShifts()
        assertEquals(shifts, viewModel.shifts.first())
    }
}*/
