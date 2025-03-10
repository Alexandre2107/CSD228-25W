package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class UserRepositoryTest {

    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        userRepository = UserRepository()
    }

    @Test
    fun testGetUser() = runBlocking {
        val user = userRepository.getUser()
        assertEquals("user1", user.id)
        assertEquals("John Doe", user.name)
    }

    @Test
    fun testUpdateUser() = runBlocking {
        userRepository.updateUser(name = "Jane Doe", email = "jane@example.com")
        val updatedUser = userRepository.getUser()
        assertEquals("Jane Doe", updatedUser.name)
        assertEquals("jane@example.com", updatedUser.email)
    }
}