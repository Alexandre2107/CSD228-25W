package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.Shift
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.Duration
import java.time.Instant

class ShiftRepositoryTest {

    private lateinit var shiftRepository: ShiftRepository

    @Before
    fun setUp() {
        shiftRepository = ShiftRepository()
    }

    @Test
    fun testGetAllShifts() = runBlocking {
        val shifts = shiftRepository.getAllShifts()
        assertEquals(2, shifts.size)
    }

    @Test
    fun testGetUpcomingShifts() = runBlocking {
        val upcomingShifts = shiftRepository.getUpcomingShifts()
        assertEquals(1, upcomingShifts.size)
    }

    @Test
    fun testUpdateShift() = runBlocking {
        val shift = Shift(
            id = "shift1",
            userId = "user1",
            startTime = Instant.now(),
            endTime = Instant.now().plus(Duration.ofDays(1) + Duration.ofHours(8)),
            location = "Updated Office",
            description = "Updated Morning Shift"
        )
        shiftRepository.updateShift(shift)
        val updatedShift = shiftRepository.getAllShifts().first { it.id == "shift1" }
        assertEquals("Updated Office", updatedShift.location)
        assertEquals("Updated Morning Shift", updatedShift.description)
    }
}