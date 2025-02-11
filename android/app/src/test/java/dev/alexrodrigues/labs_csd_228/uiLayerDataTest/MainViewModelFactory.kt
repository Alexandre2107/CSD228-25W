package dev.alexrodrigues.labs_csd_228.ui

import dev.alexrodrigues.labs_csd_228.data.repository.CalendarRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelFactoryTest {

    private lateinit var userRepository: UserRepository
    private lateinit var shiftRepository: ShiftRepository
    private lateinit var calendarRepository: CalendarRepository
    private lateinit var factory: MainViewModelFactory

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        userRepository = UserRepository()
        shiftRepository = ShiftRepository()
        calendarRepository = CalendarRepository(shiftRepository)
        factory = MainViewModelFactory(userRepository, shiftRepository, calendarRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testCreate() {
        val viewModel = factory.create(MainViewModel::class.java)
        assertTrue(viewModel is MainViewModel)
    }
}