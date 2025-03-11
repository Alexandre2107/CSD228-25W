package dev.alexrodrigues.labs_csd_228.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import dev.alexrodrigues.labs_csd_228.data.repository.SettingsRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.ui.AppNavGraph
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel
import dev.alexrodrigues.labs_csd_228.ui.viewModel.SettingsViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class EmployeesPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavHostController

    @Composable
    fun TestNavHost(
        navController: NavHostController,
        userViewModel: UserViewModel,
        shiftViewModel: ShiftViewModel,
        settingsViewModel: SettingsViewModel
    ) {
        NavHost(
            navController = navController,
            startDestination = "employees"
        ) {
            AppNavGraph(
                navController = navController,
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }
    }

    @Test
    fun testEmployeesPageDisplaysCorrectly() {
        val settingsViewModel = SettingsViewModel(settingsRepository = SettingsRepository())
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        val shiftViewModel = ShiftViewModel(shiftRepository)

        composeTestRule.setContent {
            navController = rememberNavController()
            TestNavHost(
                navController = navController,
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        composeTestRule.onNodeWithText("Employees List").assertExists()
    }

    @Test
    fun testNavigateToSettings() {
        val settingsViewModel = SettingsViewModel(settingsRepository = SettingsRepository())
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        val shiftViewModel = ShiftViewModel(shiftRepository)

        composeTestRule.setContent {
            navController = rememberNavController()
            TestNavHost(
                navController = navController,
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        composeTestRule.onNodeWithText("Go to Settings").performClick()

        composeTestRule.runOnIdle {
            assert(navController.currentDestination?.route == "settings")
        }
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
            TestNavHost(
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
    fun testNavigateToEmployeeDetails() {
        val settingsViewModel = SettingsViewModel(settingsRepository = SettingsRepository())
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        val shiftViewModel = ShiftViewModel(shiftRepository)

        composeTestRule.setContent {
            navController = rememberNavController()
            TestNavHost(
                navController = navController,
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        // Assuming there is at least one user in the list
        val user = userViewModel.users.value.first()
        composeTestRule.onNodeWithText("Go to Employee Details").performClick()

        composeTestRule.runOnIdle {
            assert(navController.currentDestination?.route == "employee_details/${user.id}")
        }
    }
}