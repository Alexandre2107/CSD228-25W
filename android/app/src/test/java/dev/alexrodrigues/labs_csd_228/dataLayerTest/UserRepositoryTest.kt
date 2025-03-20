package dev.alexrodrigues.labs_csd_228.dataLayerTest

import dev.alexrodrigues.labs_csd_228.data.dao.UserDao
import dev.alexrodrigues.labs_csd_228.data.entities.UserEntity
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class UserRepositoryTest {

    private lateinit var userDao: UserDao
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        userDao = mock(UserDao::class.java)
        userRepository = UserRepository(userDao)
    }

    @Test
    fun testGetAllUsers(): Unit = runTest {
        userRepository.getAllUsers()
        verify(userDao).getAllUsers()
    }

    @Test
    fun testInsertUser() = runTest {
        val user = UserEntity("user1", "John Doe", "john@example.com", "1234567890", "None")
        userRepository.insertUser(user)
        verify(userDao).insertUser(user)
    }

    @Test
    fun testUpdateUser() = runTest {
        val user = UserEntity("user1", "John Doe", "john@example.com", "1234567890", "None")
        userRepository.updateUser(user)
        verify(userDao).updateUser(user)
    }

    @Test
    fun testDeleteUser() = runTest {
        val user = UserEntity("user1", "John Doe", "john@example.com", "1234567890", "None")
        userRepository.deleteUser(user)
        verify(userDao).deleteUser(user)
    }

    @Test
    fun testGetNextUserId() = runTest {
        `when`(userDao.getAllUsers()).thenReturn(listOf(UserEntity("user1", "John Doe", "john@example.com", "1234567890", "None")))
        val nextUserId = userRepository.getNextUserId()
        assert(nextUserId == "user2")
    }
}