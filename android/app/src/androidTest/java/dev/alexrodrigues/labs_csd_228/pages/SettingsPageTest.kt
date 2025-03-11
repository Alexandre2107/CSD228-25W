package dev.alexrodrigues.labs_csd_228.pages

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import dev.alexrodrigues.labs_csd_228.data.repository.SettingsRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.ui.AppNavGraph
import dev.alexrodrigues.labs_csd_228.ui.SettingsViewModel
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class SettingsPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavHostController

    @Test
    fun testSettingsPageDisplaysCorrectly() {
        val settingsViewModel = SettingsViewModel(settingsRepository = SettingsRepository())
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        val shiftViewModel = ShiftViewModel(shiftRepository)

        composeTestRule.setContent {
            navController = rememberNavController()
            AppNavGraph(
                navController = navController,
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        composeTestRule.onNodeWithText("Settings Page").assertExists()
    }

    @Test
    fun testNavigateToShifts() {
        val settingsViewModel = SettingsViewModel(settingsRepository = SettingsRepository())
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        val shiftViewModel = ShiftViewModel(shiftRepository)

        composeTestRule.setContent {
            navController = rememberNavController()
            AppNavGraph(
                navController = navController,
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        composeTestRule.onNodeWithText("Go to Shifts").performClick()

        composeTestRule.runOnIdle {
            assert(navController.currentDestination?.route == "shifts")
        }
    }

    @Test
    fun testNavigateToEmployees() {
        val settingsViewModel = SettingsViewModel(settingsRepository = SettingsRepository())
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        val shiftViewModel = ShiftViewModel(shiftRepository)

        composeTestRule.setContent {
            navController = rememberNavController()
            AppNavGraph(
                navController = navController,
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        composeTestRule.onNodeWithText("Go to Employees").performClick()

        composeTestRule.runOnIdle {
            assert(navController.currentDestination?.route == "employees")
        }
    }
}