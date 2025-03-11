package dev.alexrodrigues.labs_csd_228.ui.viewModel

import dev.alexrodrigues.labs_csd_228.data.Settings
import dev.alexrodrigues.labs_csd_228.data.repository.SettingsRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SettingsViewModelTest {

    private lateinit var settingsRepository: SettingsRepository
    private lateinit var settingsViewModel: SettingsViewModel

    @Before
    fun setUp() {
        settingsRepository = SettingsRepository()
        settingsViewModel = SettingsViewModel(settingsRepository)
    }

    @Test
    fun testGetSettings() = runTest {
        val settings = settingsViewModel.settings.first()
        assertEquals(Settings.DEFAULT, settings)
    }

    @Test
    fun testUpdateSettings() = runTest {
        val newSettings = Settings(darkMode = true)
        settingsViewModel.updateSettings(newSettings)
        val updatedSettings = settingsViewModel.settings.first()
        assertEquals(newSettings, updatedSettings)
    }
}