package dev.alexrodrigues.labs_csd_228.ui.page.employees

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material3.*

/**
 * Displays a dialog for adding a new employee
 *
 * @param navController The NavHostController used for navigation
 */
@Composable
fun AddEmployeeDialog(navController: NavHostController) {
    AlertDialog(
        onDismissRequest = { navController.popBackStack() },
        title = { Text(text = "Add Employee") },
        text = { Text(text = "Employee creation form") },
        confirmButton = {
            // Button to confirm employee addition
            Button(onClick = { navController.popBackStack() }) {
                Text("Add")
            }
        },
        dismissButton = {
            // Button to cancel employee addition
            Button(onClick = { navController.popBackStack() }) {
                Text("Cancel")
            }
        }
    )
}