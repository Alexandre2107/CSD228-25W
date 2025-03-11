package dev.alexrodrigues.labs_csd_228.ui.page.employees

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel

/**
 * Displays the list of employees
 *
 * @param navController The NavHostController used for navigation
 * @param viewModel The ViewModel that provides the employee data
 */
@Composable
fun EmployeesPage(navController: NavHostController, viewModel: UserViewModel) {
    // Collect the list of users from the ViewModel
    val users by viewModel.users.collectAsState()

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            // Button to navigate to the settings page
            Button(onClick = { navController.navigate("settings") }) {
                Text(text = "Go to Settings")
            }
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            // Button to navigate to the shifts page
            Button(onClick = { navController.navigate("shifts") }) {
                Text(text = "Go to Shifts")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Employees List", color = MaterialTheme.colorScheme.onSurface)
        // Display the list of users
        users.forEach { user ->
            Text(text = "Name: ${user.name}, Email: ${user.email}, Phone: ${user.phone}", color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(8.dp))
            // Button to navigate to the employee details page
            Button(onClick = { navController.navigate("employee_details/${user.id}") }) {
                Text(text = "Go to Employee Details")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Button to navigate to the add employee page
        Button(onClick = { navController.navigate("add_employee") }) {
            Text(text = "Add Employee")
        }
    }
}