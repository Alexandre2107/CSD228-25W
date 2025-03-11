package dev.alexrodrigues.labs_csd_228.ui.page.employees

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel

/**
 * Displays the details of a specific employee
 *
 * @param navController The NavHostController used for navigation
 * @param employeeId The ID of the employee whose details are to be displayed
 * @param viewModel The ViewModel that provides the employee data
 */
@Composable
fun EmployeeDetailsPage(navController: NavHostController, employeeId: String?, viewModel: UserViewModel) {
    // Collect the list of users from the ViewModel
    val users by viewModel.users.collectAsState()
    // Find the user with the given employeeId
    val user = users.find { it.id == employeeId }
    // Get the shifts for the user
    val shifts = employeeId?.let { viewModel.getShiftsForUser(it) } ?: emptyList()

    Column(modifier = Modifier.padding(16.dp)) {
        // Button to navigate back to the employees list
        Button(onClick = { navController.navigate("employees") }) {
            Text(text = "Go back to Employees")
        }
        user?.let {
            // Display user details
            Text(text = "Employee Details", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "ID: ${it.id}", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "Name: ${it.name}", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "Email: ${it.email}", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "Phone: ${it.phone}", color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Shifts", color = MaterialTheme.colorScheme.onSurface)
            // Display shifts for the user
            shifts.forEach { shifts ->
                Text(text = "Shift ID: ${shifts.id}", color = MaterialTheme.colorScheme.onSurface)
                Text(text = "Location: ${shifts.location}", color = MaterialTheme.colorScheme.onSurface)
                Text(text = "Description: ${shifts.description}", color = MaterialTheme.colorScheme.onSurface)
                Spacer(modifier = Modifier.height(8.dp))
            }
        } ?: run {
            // Display message if user is not found
            Text(text = "Employee not found", color = MaterialTheme.colorScheme.onSurface)
        }
    }
}