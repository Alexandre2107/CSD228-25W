package dev.alexrodrigues.labs_csd_228

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.data.repository.CalendarRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.ui.MainScreen
import dev.alexrodrigues.labs_csd_228.ui.MainViewModel
import dev.alexrodrigues.labs_csd_228.ui.MainViewModelFactory
import dev.alexrodrigues.labs_csd_228.ui.theme.ThemeSwitcherTheme

/**
 * Main activity of the application.
 */
class MainActivity : ComponentActivity() {
    /**
     * Called when the activity is starting.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // State to manage the theme (dark or light)
            var darkTheme by remember { mutableStateOf(false) }

            // Apply the theme to the content
            ThemeSwitcherTheme(darkTheme = darkTheme) {
                // Initialize repositories
                val userRepository = UserRepository()
                val shiftRepository = ShiftRepository()
                val calendarRepository = CalendarRepository(shiftRepository)

                // Create ViewModelFactory
                val viewModelFactory = MainViewModelFactory(userRepository, shiftRepository, calendarRepository)

                // Get ViewModel instance
                val viewModel: MainViewModel = ViewModelProvider(this@MainActivity, viewModelFactory).get(MainViewModel::class.java)

                // Set the main screen content
                MainScreen(darkTheme = darkTheme, onThemeUpdated = { darkTheme = !darkTheme }, viewModel = viewModel)
            }
        }
    }
}