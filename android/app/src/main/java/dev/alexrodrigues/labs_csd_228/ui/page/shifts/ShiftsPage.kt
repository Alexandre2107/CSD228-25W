package dev.alexrodrigues.labs_csd_228.ui.page.shifts

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
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel

/**
 * Displays the list of shifts.
 *
 * @param navController The NavHostController used for navigation.
 * @param viewModel The ViewModel that provides the shift data.
 */
@Composable
fun ShiftsPage(navController: NavHostController, viewModel: ShiftViewModel) {
    // Collect the list of shifts from the ViewModel
    val shifts by viewModel.shifts.collectAsState()

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            // Button to navigate to the settings page
            Button(onClick = { navController.navigate("settings") }) {
                Text(text = "Go to Settings")
            }
            Spacer(Modifier.padding(horizontal = 10.dp))
            // Button to navigate to the employees page
            Button(onClick = { navController.navigate("employees") }) {
                Text(text = "Go to Employees")
            }
        }
        Text(text = "Shifts List", color = MaterialTheme.colorScheme.onSurface)
        // Display the list of shifts
        shifts.forEach { shift ->
            Text(text = "Shift ID: ${shift.id}, Location: ${shift.location}, Description: ${shift.description}", color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(8.dp))
            // Button to navigate to the shift details page
            Button(onClick = { navController.navigate("shift_details/${shift.id}") }) {
                Text(text = "Go to Shift Details")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Button to navigate to the create shift page
        Button(onClick = { navController.navigate("create_shift") }) {
            Text(text = "Create Shift")
        }
    }
}