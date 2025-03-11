package dev.alexrodrigues.labs_csd_228.ui.page.shifts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material3.*

/**
 * Displays a dialog for creating a new shift
 *
 * @param navController The NavHostController used for navigation
 */
@Composable
fun CreateShiftDialog(navController: NavHostController) {
    AlertDialog(
        onDismissRequest = { navController.popBackStack() },
        title = { Text(text = "Create Shift") },
        text = { Text(text = "Shift creation form") },
        confirmButton = {
            // Button to confirm shift creation
            Button(onClick = { navController.popBackStack() }) {
                Text("Create")
            }
        },
        dismissButton = {
            // Button to cancel shift creation
            Button(onClick = { navController.popBackStack() }) {
                Text("Cancel")
            }
        }
    )
}