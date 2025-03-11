package dev.alexrodrigues.labs_csd_228.ui.page.employees

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material3.*

/**
 * Displays a dialog for adding a new employee
 *
 * @param popBackStack The function to pop the back stack
 */
@Composable
fun AddEmployeeDialog(popBackStack: () -> Unit = {}) {
    AlertDialog(
        onDismissRequest = popBackStack,
        title = { Text(text = "Add Employee") },
        text = { Text(text = "Employee creation form") },
        confirmButton = {
            // Button to confirm employee addition
            Button(onClick = popBackStack) {
                Text("Add")
            }
        },
        dismissButton = {
            // Button to cancel employee addition
            Button(onClick = popBackStack ) {
                Text("Cancel")
            }
        }
    )
}