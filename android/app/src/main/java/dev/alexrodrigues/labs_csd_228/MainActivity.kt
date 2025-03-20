package dev.alexrodrigues.labs_csd_228

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.alexrodrigues.labs_csd_228.data.AppDatabase
import dev.alexrodrigues.labs_csd_228.data.repository.*
import dev.alexrodrigues.labs_csd_228.ui.*
import dev.alexrodrigues.labs_csd_228.ui.theme.ThemeSwitcherTheme
import dev.alexrodrigues.labs_csd_228.ui.viewModel.*

/**
 * Main activity of the application
 */
class MainActivity : ComponentActivity() {

    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it had before it was shut down
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Initialize repositories
            val userRepository = UserRepository(
                userDao = AppDatabase.getDatabase(applicationContext).userDao()
            )
            val shiftRepository = ShiftRepository(
                shiftDao = AppDatabase.getDatabase(applicationContext).shiftDao()
            )

            // Initialize ViewModels
            val userViewModel = UserViewModel(userRepository, shiftRepository)
            val shiftViewModel = ShiftViewModel(shiftRepository)
            val settingsViewModel = SettingsViewModel(
                context = applicationContext
            )

            // Collect settings state
            val settings by settingsViewModel.settings.collectAsState(initial = SettingsProto.Settings.getDefaultInstance())

            // Set the theme and main screen content
            ThemeSwitcherTheme(darkTheme = settings.darkMode) {
                MainScreen(
                    darkTheme = settings.darkMode,
                    onThemeUpdated = {
                        settingsViewModel.updateSettings(!settings.darkMode)
                    },
                    userViewModel = userViewModel,
                    shiftViewModel = shiftViewModel,
                    settingsViewModel = settingsViewModel
                )
            }
        }
    }
}