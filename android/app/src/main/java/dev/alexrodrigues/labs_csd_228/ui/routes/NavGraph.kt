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
import dev.alexrodrigues.labs_csd_228.ui.routes.*
import dev.alexrodrigues.labs_csd_228.ui.viewModel.*

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    userViewModel: UserViewModel,
    shiftViewModel: ShiftViewModel,
    settingsViewModel: SettingsViewModel
) {
    // Define the navigation host with the start destination as the settings route
    NavHost(navController = navController, startDestination = SettingsRoute::class.java.name) {
        // Define the composable for the settings page
        composable(SettingsRoute::class.java.name) {
            SettingsPage(
                popBackStack = { navController.popBackStack() },
                navigateToShifts = { navController.navigate(ShiftsRoute::class.java.name) },
                navigateToEmployees = { navController.navigate(EmployeesRoute::class.java.name) }
            )
        }

        // Define the navigation graph for shifts
        navigation(startDestination = ShiftsRoute::class.java.name, route = "shifts") {
            // Define the composable for the shifts page
            composable(ShiftsRoute::class.java.name) {
                ShiftsPage(
                    popBackStack = { navController.popBackStack() },
                    onSelectShift = { shiftId -> navController.navigate(ShiftDetailsRoute::class.java.name + "/$shiftId") },
                    navigateToShifts = { navController.navigate(SettingsRoute::class.java.name) },
                    navigateToEmployees = { navController.navigate(EmployeesRoute::class.java.name) },
                    navToAddShift = { navController.navigate(CreateShiftRoute::class.java.name) },
                    viewModel = shiftViewModel
                )
            }
            // Define the composable for the shift details page
            composable("${ShiftDetailsRoute::class.java.name}/{shiftId}") { backStackEntry ->
                val shiftId = backStackEntry.arguments?.getString("shiftId")
                ShiftDetailsPage(
                    popBackStack = { navController.popBackStack() },
                    shiftId = shiftId,
                    navigateToShifts = { navController.navigate(ShiftsRoute::class.java.name) },
                    viewModel = shiftViewModel
                )
            }
            // Define the dialog for creating a new shift
            dialog(CreateShiftRoute::class.java.name) {
                CreateShiftDialog(popBackStack = { navController.popBackStack() })
            }
        }

        // Define the navigation graph for employees
        navigation(startDestination = EmployeesRoute::class.java.name, route = "employees") {
            // Define the composable for the employees page
            composable(EmployeesRoute::class.java.name) {
                EmployeesPage(
                    popBackStack = { navController.popBackStack() },
                    onSelectUser = { userId -> navController.navigate(EmployeeDetailsRoute::class.java.name + "/$userId") },
                    navigateToShifts = { navController.navigate(ShiftsRoute::class.java.name) },
                    navigateToSettings = { navController.navigate(SettingsRoute::class.java.name) },
                    navToAddEmployee = { navController.navigate(AddEmployeeRoute::class.java.name) },
                    viewModel = userViewModel
                )
            }
            // Define the composable for the employee details page
            composable("${EmployeeDetailsRoute::class.java.name}/{employeeId}") { backStackEntry ->
                val employeeId = backStackEntry.arguments?.getString("employeeId")
                EmployeeDetailsPage(
                    popBackStack = { navController.popBackStack() },
                    employeeId = employeeId,
                    navigateToEmployees = { navController.navigate(EmployeesRoute::class.java.name) },
                    viewModel = userViewModel
                )
            }
            // Define the dialog for adding a new employee
            dialog(AddEmployeeRoute::class.java.name) {
                AddEmployeeDialog(popBackStack = { navController.popBackStack() })
            }
        }
    }
}