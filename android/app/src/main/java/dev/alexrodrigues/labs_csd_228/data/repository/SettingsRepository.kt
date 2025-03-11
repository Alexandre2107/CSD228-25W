package dev.alexrodrigues.labs_csd_228.data.repository

import dev.alexrodrigues.labs_csd_228.data.Settings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Repository for managing settings data
 */
class SettingsRepository {
    // Mutable state flow for settings data
    private val _settings = MutableStateFlow(Settings(darkMode = false))
    // State flow for settings data
    val settings: StateFlow<Settings> = _settings

    /**
     * Update the settings data
     *
     * @param newSettings New settings data
     */
    fun updateSettings(newSettings: Settings) {
        _settings.value = newSettings
    }
}