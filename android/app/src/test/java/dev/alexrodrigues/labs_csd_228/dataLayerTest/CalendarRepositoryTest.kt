package dev.alexrodrigues.labs_csd_228.dataLayerTest

import dev.alexrodrigues.labs_csd_228.data.Calendar
import dev.alexrodrigues.labs_csd_228.data.repository.CalendarRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.ZoneId

class CalendarRepositoryTest {
    private lateinit var shiftRepository: ShiftRepository
    private lateinit var calendarRepository: CalendarRepository

    @Before
    fun setUp() {
        shiftRepository = ShiftRepository()
        calendarRepository = CalendarRepository(shiftRepository)
    }

    @Test
    fun testGetCalendar() = runBlocking {
        val calendar: Calendar = calendarRepository.getCalendar()
        val shifts = shiftRepository.getAllShifts()
        val shiftsByDate = shifts.groupBy { shift ->
            shift.startTime.atZone(ZoneId.systemDefault()).toLocalDate()
        }
        assertEquals(shiftsByDate, calendar.shiftsByDate)
    }
}