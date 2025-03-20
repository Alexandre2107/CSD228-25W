package dev.alexrodrigues.labs_csd_228.data

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.Instant

class ModelsTest {

    @Test
    fun testUser() {
        val user = User("user1", "John Doe", "john@example.com", "123-456-7890", listOf("High Contrast"))
        assertEquals("user1", user.id)
        assertEquals("John Doe", user.name)
        assertEquals("john@example.com", user.email)
        assertEquals("123-456-7890", user.phone)
        assertEquals(listOf("High Contrast"), user.accessibilityRequirements)
    }

    @Test
    fun testShift() {
        val shift = Shift("shift1", "user1", Instant.now(), Instant.now().plusSeconds(3600), "Office", "Morning Shift")
        assertEquals("shift1", shift.id)
        assertEquals("user1", shift.userId)
        assertEquals("Office", shift.location)
        assertEquals("Morning Shift", shift.description)
    }

    @Test
    fun testSettings() {
        val settings = Settings(darkMode = true)
        assertEquals(true, settings.darkMode)
    }
}