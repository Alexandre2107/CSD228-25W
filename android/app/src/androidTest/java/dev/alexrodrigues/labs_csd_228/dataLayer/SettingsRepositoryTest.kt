package dev.alexrodrigues.labs_csd_228.dataLayer

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Serializer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.alexrodrigues.labs_csd_228.SettingsProto
import dev.alexrodrigues.labs_csd_228.data.repository.SettingsRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.io.InputStream
import java.io.OutputStream

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class SettingsRepositoryTest {

    private lateinit var settingsRepository: SettingsRepository
    private lateinit var dataStore: DataStore<SettingsProto.Settings>

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val testFile = File(context.cacheDir, "test_settings.pb")
        dataStore = DataStoreFactory.create(
            serializer = object : Serializer<SettingsProto.Settings> {
                override val defaultValue: SettingsProto.Settings =
                    SettingsProto.Settings.getDefaultInstance()
                override suspend fun readFrom(input: InputStream): SettingsProto.Settings {
                    return SettingsProto.Settings.parseFrom(input)
                }
                override suspend fun writeTo(t: SettingsProto.Settings, output: OutputStream) {
                    t.writeTo(output)
                }
            },
            produceFile = { testFile }
        )
        settingsRepository = SettingsRepository(context)
    }

    @Test
    fun testGetSettings() = runTest {
        val settings = settingsRepository.settings.first()
        assertEquals(false, settings.darkMode)
    }

    @Test
    fun testUpdateSettings() = runTest {
        val newSettings = SettingsProto.Settings.newBuilder().setDarkMode(true).build()
        settingsRepository.updateSettings(newSettings)
        val updatedSettings = settingsRepository.settings.first()
        assertEquals(true, updatedSettings.darkMode)
    }
}