package dev.alexrodrigues.labs_csd_228.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import dev.alexrodrigues.labs_csd_228.ui.page.employees.*
import dev.alexrodrigues.labs_csd_228.ui.page.settings.SettingsPage
import dev.alexrodrigues.labs_csd_228.ui.page.shifts.*
import dev.alexrodrigues.labs_csd_228.ui.viewModel.*

/**
 * Sets up the navigation graph for the app
 *
 * @param navController The NavHostController used for navigation
 * @param userViewModel The ViewModel for user data
 * @param shiftViewModel The ViewModel for shift data
 * @param settingsViewModel The ViewModel for settings data
 */
@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    userViewModel: UserViewModel,
    shiftViewModel: ShiftViewModel,
    settingsViewModel: SettingsViewModel
) {
    // Define the navigation host
    NavHost(navController = navController, startDestination = "settings") {
        // Composable for the settings page
        composable("settings") { SettingsPage(navController, settingsViewModel) }

        // Navigation graph for shifts
        navigation(startDestination = "shifts", route = "shifts_graph") {
            composable("shifts") { ShiftsPage(navController, shiftViewModel) }
            composable("shift_details/{shiftId}") { backStackEntry ->
                val shiftId = backStackEntry.arguments?.getString("shiftId")
                ShiftDetailsPage(navController, shiftId, shiftViewModel)
            }
            dialog("create_shift") { CreateShiftDialog(navController) }
        }

        // Navigation graph for employees
        navigation(startDestination = "employees", route = "employees_graph") {
            composable("employees") { EmployeesPage(navController, userViewModel) }
            composable("employee_details/{employeeId}") { backStackEntry ->
                val employeeId = backStackEntry.arguments?.getString("employeeId")
                EmployeeDetailsPage(navController, employeeId, userViewModel)
            }
            dialog("add_employee") { AddEmployeeDialog(navController) }
        }
    }
}