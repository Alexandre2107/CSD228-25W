package dev.alexrodrigues.labs_csd_228.ui.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alexrodrigues.labs_csd_228.SettingsProto
import dev.alexrodrigues.labs_csd_228.data.settingsDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * ViewModel for settings data
 * @param context The application context
 */
class SettingsViewModel(context: Context) : ViewModel() {
    private val dataStore = context.settingsDataStore

    // Flow of settings data
    val settings: Flow<SettingsProto.Settings> = dataStore.data

    /**
     * Update settings
     * @param darkMode The new dark mode setting
     */
    fun updateSettings(darkMode: Boolean) {
        viewModelScope.launch {
            dataStore.updateData { currentSettings ->
                currentSettings.toBuilder().setDarkMode(darkMode).build()
            }
        }
    }
}