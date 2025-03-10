package dev.alexrodrigues.labs_csd_228.uiLayerDataTest

import dev.alexrodrigues.labs_csd_228.data.User
import dev.alexrodrigues.labs_csd_228.data.repository.CalendarRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    private lateinit var userRepository: UserRepository
    private lateinit var shiftRepository: ShiftRepository
    private lateinit var calendarRepository: CalendarRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        userRepository = UserRepository()
        shiftRepository = ShiftRepository()
        calendarRepository = CalendarRepository(shiftRepository)
        viewModel = MainViewModel(userRepository, shiftRepository, calendarRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testUpdateUser() = runTest {
        val user = User("user1", "Jane Doe", "jane@example.com", "123-456-7890", listOf("High Contrast"))
        viewModel.updateUser(user)
        assertEquals("Jane Doe", viewModel.user.value?.name)
        assertEquals("jane@example.com", viewModel.user.value?.email)
    }

    @Test
    fun testUpdateShift() = runTest {
        val shift = shiftRepository.getAllShifts().first()
        shift.location = "Updated Location"
        viewModel.updateShift(shift)
        assertEquals("Updated Location", viewModel.shifts.value.first().location)
    }
}