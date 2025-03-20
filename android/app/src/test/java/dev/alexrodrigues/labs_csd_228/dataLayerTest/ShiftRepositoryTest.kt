package dev.alexrodrigues.labs_csd_228.dataLayerTest

import dev.alexrodrigues.labs_csd_228.data.dao.ShiftDao
import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class ShiftRepositoryTest {

    private lateinit var shiftDao: ShiftDao
    private lateinit var shiftRepository: ShiftRepository

    @Before
    fun setUp() {
        shiftDao = mock(ShiftDao::class.java)
        shiftRepository = ShiftRepository(shiftDao)
    }

    @Test
    fun testGetAllShifts(): Unit = runTest {
        shiftRepository.getAllShifts()
        verify(shiftDao).getAllShifts()
    }

    @Test
    fun testInsertShift() = runTest {
        val shift = ShiftEntity("shift1", "user1", 1620000000000, 1620003600000, "Office", "Morning shift")
        shiftRepository.insertShift(shift)
        verify(shiftDao).insertShift(shift)
    }

    @Test
    fun testUpdateShift() = runTest {
        val shift = ShiftEntity("shift1", "user1", 1620000000000, 1620003600000, "Office", "Morning shift")
        shiftRepository.updateShift(shift)
        verify(shiftDao).updateShift(shift)
    }

    @Test
    fun testDeleteShift() = runTest {
        val shift = ShiftEntity("shift1", "user1", 1620000000000, 1620003600000, "Office", "Morning shift")
        shiftRepository.deleteShift(shift)
        verify(shiftDao).deleteShift(shift)
    }

    @Test
    fun testGetNextShiftId() = runTest {
        `when`(shiftDao.getAllShifts()).thenReturn(listOf(ShiftEntity("shift1", "user1", 1620000000000, 1620003600000, "Office", "Morning shift")))
        val nextShiftId = shiftRepository.getNextShiftId()
        assert(nextShiftId == "shift2")
    }
}