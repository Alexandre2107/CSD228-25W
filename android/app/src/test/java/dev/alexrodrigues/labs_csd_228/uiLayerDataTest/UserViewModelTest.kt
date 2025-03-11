package dev.alexrodrigues.labs_csd_228.ui.viewModel

import dev.alexrodrigues.labs_csd_228.data.User
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

@ExperimentalCoroutinesApi
class UserViewModelTest {

    private lateinit var userRepository: UserRepository
    private lateinit var shiftRepository: ShiftRepository
    private lateinit var userViewModel: UserViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        userRepository = UserRepository()
        shiftRepository = ShiftRepository()
        userViewModel = UserViewModel(userRepository, shiftRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun containsAllUsers() = runTest {
        val initialUsers = userRepository.getAllUsers()
        val viewModelUsers = userViewModel.users.value

        assertEquals(initialUsers.size, viewModelUsers.size)
        assertTrue(viewModelUsers.containsAll(initialUsers))
    }

    @Test
    fun updateUser() = runTest {
        val updatedUser = User(
            id = "user1",
            name = "New Name",
            email = "new@example.com",
            phone = "111-222-3333",
            accessibilityRequirements = listOf("New Requirement")
        )

        userViewModel.updateUser(updatedUser)

        val updatedUsers = userViewModel.users.value
        val modifiedUser = updatedUsers.find { it.id == "user1" }

        assertNotNull(modifiedUser)
        assertEquals("New Name", modifiedUser!!.name)
        assertEquals("new@example.com", modifiedUser.email)
        assertEquals("111-222-3333", modifiedUser.phone)
        assertEquals(listOf("New Requirement"), modifiedUser.accessibilityRequirements)
    }
}