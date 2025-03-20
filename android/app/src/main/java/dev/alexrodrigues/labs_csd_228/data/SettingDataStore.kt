package dev.alexrodrigues.labs_csd_228.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import dev.alexrodrigues.labs_csd_228.SettingsProto
import java.io.InputStream
import java.io.OutputStream

/**
 * Serializer for the settings
 */
object SettingsSerializer : Serializer<SettingsProto.Settings> {
    override val defaultValue: SettingsProto.Settings = SettingsProto.Settings.getDefaultInstance()

    /**
     * Read settings from input stream
     * @param input The input stream
     */
    override suspend fun readFrom(input: InputStream): SettingsProto.Settings {
        return SettingsProto.Settings.parseFrom(input)
    }

    /**
     * Write settings to output stream
     * @param t The settings to write
     * @param output The output stream
     */
    override suspend fun writeTo(t: SettingsProto.Settings, output: OutputStream) {
        t.writeTo(output)
    }
}

/**
 * Extension property to get the settings DataStore
 */
val Context.settingsDataStore: DataStore<SettingsProto.Settings> by dataStore(
    fileName = "settings.pb",
    serializer = SettingsSerializer
)