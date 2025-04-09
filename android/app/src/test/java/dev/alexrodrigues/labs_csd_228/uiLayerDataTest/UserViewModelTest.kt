/*
package dev.alexrodrigues.labs_csd_228.uiLayerDataTest

import dev.alexrodrigues.labs_csd_228.data.entities.UserEntity
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class UserViewModelTest {

    private lateinit var viewModel: UserViewModel
    private lateinit var userRepository: UserRepository
    private lateinit var shiftRepository: ShiftRepository

    @Before
    fun setUp() {
        userRepository = mock(UserRepository::class.java)
        shiftRepository = mock(ShiftRepository::class.java)
        viewModel = UserViewModel(userRepository, shiftRepository)
    }

    @Test
    fun testInsertUser() = runBlocking {
        val user = UserEntity("user1", "John Doe", "john@example.com", "123-456-7890",
            listOf("High Contrast").toString()
        )
        viewModel.insertUser(user)
        verify(userRepository).insertUser(any(UserEntity::class.java))
    }

    @Test
    fun testDeleteUser() = runBlocking {
        val user = UserEntity("user1", "John Doe", "john@example.com", "123-456-7890",
            listOf("High Contrast").toString()
        )
        viewModel.deleteUser(user)
        verify(userRepository).deleteUser(user)
    }

    @Test
    fun testFetchAllUsers() = runBlocking {
        val users = listOf(UserEntity("user1", "John Doe", "john@example.com", "123-456-7890",
            listOf("High Contrast").toString()
        ))
        `when`(userRepository.getAllUsers()).thenReturn(users)
        viewModel.fetchAllUsers()
        assertEquals(users, viewModel.users.first())
    }
}*/
