package dev.alexrodrigues.labs_csd_228.ui.viewModel

import dev.alexrodrigues.labs_csd_228.data.Shift
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.time.Duration
import java.time.Instant

@ExperimentalCoroutinesApi
class ShiftViewModelTest {

    private lateinit var shiftRepository: ShiftRepository
    private lateinit var shiftViewModel: ShiftViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        shiftRepository = ShiftRepository()
        shiftViewModel = ShiftViewModel(shiftRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun containsAllShifts() = runTest {
        val initialShifts = shiftRepository.getAllShifts()
        val viewModelShifts = shiftViewModel.shifts.value

        assertEquals(initialShifts.size, viewModelShifts.size)
        assertTrue(viewModelShifts.containsAll(initialShifts))
    }

    @Test
    fun updateShift() = runTest {
        val updatedShift = Shift(
            id = "shift1",
            userId = "user1",
            startTime = Instant.now(),
            endTime = Instant.now().plus(Duration.ofHours(10)),
            location = "Updated Location",
            description = "Updated Description"
        )

        shiftViewModel.updateShift(updatedShift)

        val updatedShifts = shiftViewModel.shifts.value
        val modifiedShift = updatedShifts.find { it.id == "shift1" }

        assertNotNull(modifiedShift)
        assertEquals("Updated Location", modifiedShift!!.location)
        assertEquals("Updated Description", modifiedShift.description)
    }
}