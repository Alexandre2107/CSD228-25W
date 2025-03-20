/*
package dev.alexrodrigues.labs_csd_228.uiLayerDataTest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import dev.alexrodrigues.labs_csd_228.ui.viewModel.SettingsViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SettingsViewModelTest {

    private lateinit var viewModel: SettingsViewModel
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        viewModel = SettingsViewModel(context)
    }

    @Test
    fun testUpdateSettings() = runBlocking {
        viewModel.updateSettings(true)
        val settings = viewModel.settings.first()
        assertEquals(true, settings.darkMode)
    }
}*/
