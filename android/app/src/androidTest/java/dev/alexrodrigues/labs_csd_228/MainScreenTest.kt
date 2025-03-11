/*
package dev.alexrodrigues.labs_csd_228

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.alexrodrigues.labs_csd_228.data.repository.CalendarRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.ui.MainScreen
import dev.alexrodrigues.labs_csd_228.ui.viewModel.MainViewModel
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testThemeSwitcherDarkMode() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val calendarRepository = CalendarRepository(shiftRepository)
        val darkTheme = mutableStateOf(false)

        composeTestRule.setContent {
            MainScreen(
                darkTheme = darkTheme.value,
                onThemeUpdated = { darkTheme.value = !darkTheme.value },
                viewModel = MainViewModel(userRepository, shiftRepository, calendarRepository),
                userViewModel = TODO(),
                shiftViewModel = TODO(),
                settingsViewModel = TODO()
            )
        }

        // Click the theme switcher
        composeTestRule.onNodeWithContentDescription("Dark Mode Icon").performClick()

        // Check if the darkTheme is updated
        assertTrue("Theme should be updated to dark mode", darkTheme.value)
    }

    @Test
    fun testThemeSwitcherLightMode() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val calendarRepository = CalendarRepository(shiftRepository)
        val darkTheme = mutableStateOf(true)

        composeTestRule.setContent {
            MainScreen(
                darkTheme = darkTheme.value,
                onThemeUpdated = { darkTheme.value = !darkTheme.value },
                viewModel = MainViewModel(userRepository, shiftRepository, calendarRepository)
            )
        }

        // Click the theme switcher
        composeTestRule.onNodeWithContentDescription("Light Mode Icon").performClick()

        // Check if the Light Mode is updated
        assertTrue("Theme should be updated to light mode", !darkTheme.value)
    }
}*/
