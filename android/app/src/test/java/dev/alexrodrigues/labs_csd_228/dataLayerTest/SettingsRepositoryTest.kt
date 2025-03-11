package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.Settings
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SettingsRepositoryTest {
    private lateinit var settingsRepository: SettingsRepository

    @Before
    fun setUp() {
        settingsRepository = SettingsRepository()
    }

    @Test
    fun testGetSettings() = runTest {
        val settings = settingsRepository.settings.first()
        assertEquals(Settings.DEFAULT, settings)
    }

    @Test
    fun testUpdateSettings() = runTest {
        val newSettings = Settings(darkMode = true)
        settingsRepository.updateSettings(newSettings)
        val updatedSettings = settingsRepository.settings.first()
        assertEquals(newSettings, updatedSettings)
    }
}