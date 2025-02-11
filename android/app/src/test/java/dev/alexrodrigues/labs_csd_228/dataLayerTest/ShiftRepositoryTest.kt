package dev.alexrodrigues.labs_csd_228.dataLayerTest

import dev.alexrodrigues.labs_csd_228.data.Shift
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
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
        val shifts: List<Shift> = shiftRepository.getAllShifts()
        assertEquals(2, shifts.size)
    }

    @Test
    fun testGetUpcomingShifts() = runBlocking {
        val upcomingShifts: List<Shift> = shiftRepository.getUpcomingShifts()
        assertEquals(1, upcomingShifts.size)
    }

    @Test
    fun testUpdateShift() = runBlocking {
        val shift = Shift(
            id = "shift1",
            userId = "user1",
            startTime = Instant.now().plus(Duration.ofDays(2)),
            endTime = Instant.now().plus(Duration.ofDays(3)),
            location = "Updated Location",
            description = "Updated Description"
        )
        shiftRepository.updateShift(shift)
        val updatedShift = shiftRepository.getAllShifts().first { it.id == "shift1" }
        assertEquals("Updated Location", updatedShift.location)
        assertEquals("Updated Description", updatedShift.description)
    }
}