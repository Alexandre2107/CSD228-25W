package dev.alexrodrigues.labs_csd_228

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.alexrodrigues.labs_csd_228.data.repository.*
import dev.alexrodrigues.labs_csd_228.ui.*
import dev.alexrodrigues.labs_csd_228.ui.theme.ThemeSwitcherTheme
import dev.alexrodrigues.labs_csd_228.ui.viewModel.*

/**
 * Main activity of the app
 */
class MainActivity : ComponentActivity() {

    // Repositories for user, shift, and settings data
    private val userRepository = UserRepository()
    private val shiftRepository = ShiftRepository()
    private val settingsRepository = SettingsRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ViewModels for user, shift, and settings data
            val userViewModel = UserViewModel(userRepository, shiftRepository)
            val shiftViewModel = ShiftViewModel(shiftRepository)
            val settingsViewModel = SettingsViewModel(settingsRepository)

            // Collect the settings state
            val settings by settingsViewModel.settings.collectAsState()

            // Set the theme and main screen content
            ThemeSwitcherTheme(darkTheme = settings.darkMode) {
                MainScreen(
                    darkTheme = settings.darkMode,
                    onThemeUpdated = {
                        settingsViewModel.updateSettings(settings.copy(darkMode = !settings.darkMode))
                    },
                    userViewModel = userViewModel,
                    shiftViewModel = shiftViewModel,
                    settingsViewModel = settingsViewModel
                )
            }
        }
    }
}