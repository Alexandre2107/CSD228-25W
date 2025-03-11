package dev.alexrodrigues.labs_csd_228.ui.viewModel

import androidx.lifecycle.ViewModel
import dev.alexrodrigues.labs_csd_228.data.Settings
import dev.alexrodrigues.labs_csd_228.data.repository.SettingsRepository
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel for managing settings data
 *
 * @property settingsRepository The repository that provides settings data
 */
class SettingsViewModel(private val settingsRepository: SettingsRepository) : ViewModel() {
    // StateFlow to hold the settings data
    val settings: StateFlow<Settings> = settingsRepository.settings

    /**
     * Updates the settings with new values.
     *
     * @param newSettings The new settings to be applied.
     */
    fun updateSettings(newSettings: Settings) {
        settingsRepository.updateSettings(newSettings)
    }
}