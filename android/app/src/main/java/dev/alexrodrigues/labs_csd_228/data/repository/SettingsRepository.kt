package dev.alexrodrigues.labs_csd_228.data.repository

import android.content.Context
import dev.alexrodrigues.labs_csd_228.SettingsProto
import dev.alexrodrigues.labs_csd_228.data.settingsDataStore
import kotlinx.coroutines.flow.Flow

/**
 * Repository for settings data
 */
class SettingsRepository(context: Context) {
    private val dataStore = context.settingsDataStore

    /**
     * Flow of settings data
     */
    val settings: Flow<SettingsProto.Settings> = dataStore.data

    /**
     * Update settings
     * @param newSettings The new settings to update
     */
    suspend fun updateSettings(newSettings: SettingsProto.Settings) {
        dataStore.updateData { newSettings }
    }
}