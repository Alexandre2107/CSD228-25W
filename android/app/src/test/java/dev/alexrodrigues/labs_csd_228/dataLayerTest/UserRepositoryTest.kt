package dev.alexrodrigues.labs_csd_228.dataLayerTest

import dev.alexrodrigues.labs_csd_228.data.User
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
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
        val user: User = userRepository.getUser()
        assertEquals("user1", user.id)
    }

    @Test
    fun testUpdateUser() = runBlocking {
        userRepository.updateUser(name = "Jane Doe", email = "jane@example.com")
        val updatedUser = userRepository.getUser()
        assertEquals("Jane Doe", updatedUser.name)
        assertEquals("jane@example.com", updatedUser.email)
    }
}