package dev.alexrodrigues.labs_csd_228.ui.page.employees

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel

/**
 * Displays the details of an employee
 * @param popBackStack Function to close the details page
 * @param employeeId The ID of the employee to display
 * @param navigateToEmployees Function to navigate to the employees list
 * @param viewModel The ViewModel that provides the employee data
 */
@Composable
fun EmployeeDetailsPage(
    popBackStack: () -> Unit = {},
    employeeId: String?,
    navigateToEmployees: () -> Unit = {},
    viewModel: UserViewModel,
) {
    // Collect the list of users from the ViewModel
    val users by viewModel.users.collectAsState()
    val user = users.find { it.id == employeeId }
    var shifts by remember { mutableStateOf(emptyList<ShiftEntity>()) }

    // Load shifts for the specific user when the employeeId changes
    LaunchedEffect(employeeId) {
        employeeId?.let {
            shifts = viewModel.getShiftsForUser(it)
        }
    }

    // Column layout to display employee details
    Column(modifier = Modifier.padding(16.dp)) {
        // Button to navigate back to the employees list
        Button(onClick = navigateToEmployees) {
            Text(text = "Go back to Employees")
        }
        user?.let {
            // Display employee details
            Text(text = "Employee Details", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "ID: ${it.id}", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "Name: ${it.name}", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "Email: ${it.email}", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "Phone: ${it.phone}", color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Shifts", color = MaterialTheme.colorScheme.onSurface)
            // Display shifts for the employee
            shifts.forEach { shift ->
                Text(text = "Shift ID: ${shift.id}", color = MaterialTheme.colorScheme.onSurface)
                Text(text = "Location: ${shift.location}", color = MaterialTheme.colorScheme.onSurface)
                Text(text = "Description: ${shift.description}", color = MaterialTheme.colorScheme.onSurface)
                Spacer(modifier = Modifier.height(8.dp))
            }
        } ?: run {
            // Display message if employee is not found
            Text(text = "Employee not found", color = MaterialTheme.colorScheme.onSurface)
        }
    }
}