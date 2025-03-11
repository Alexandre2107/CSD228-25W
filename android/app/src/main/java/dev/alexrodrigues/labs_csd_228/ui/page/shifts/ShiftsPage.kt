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
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel

/**
 * Displays the list of shifts.
 *
 * @param popBackStack The function to pop the back stack
 * @param onSelectShift The function to navigate to the details of a specific shift
 * @param navigateToShifts The function to navigate to the shifts list
 * @param navigateToEmployees The function to navigate to the employees list
 * @param navToAddShift The function to navigate to the add shift dialog
 * @param viewModel The ViewModel that provides the shift data
 */
@Composable
fun ShiftsPage(
    popBackStack: () -> Unit = {},
    onSelectShift: (String) -> Unit = {},
    navigateToShifts: () -> Unit = {},
    navigateToEmployees: () -> Unit = {},
    navToAddShift: () -> Unit = {},
    viewModel: ShiftViewModel,
) {
    // Collect the list of shifts from the ViewModel
    val shifts by viewModel.shifts.collectAsState()

    // Create a column layout with padding and fill the available size
    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        // Create a row layout to hold the navigation buttons
        Row(Modifier.align(Alignment.CenterHorizontally)) {
            // Button to navigate to the settings page
            Button(onClick = navigateToShifts) {
                Text(text = "Go to Settings")
            }
            // Spacer to add horizontal space between buttons
            Spacer(Modifier.padding(horizontal = 10.dp))
            // Button to navigate to the employees page
            Button(onClick = navigateToEmployees) {
                Text(text = "Go to Employees")
            }
        }

        // Text to display the title of the shifts list
        Text(text = "Shifts List", color = MaterialTheme.colorScheme.onSurface)

        // Loop through the list of shifts and display their details
        shifts.forEach { shift ->
            // Display the shift's ID, location, and description
            Text(text = "Shift ID: ${shift.id}, Location: ${shift.location}, Description: ${shift.description}", color = MaterialTheme.colorScheme.onSurface)
            // Spacer to add vertical space between shift details and button
            Spacer(modifier = Modifier.height(8.dp))
            // Button to navigate to the details of the selected shift
            Button(onClick = { onSelectShift(shift.id) }) {
                Text(text = "Go to Shift Details_${shift.id}")
            }
        }

        // Spacer to add vertical space
        Spacer(modifier = Modifier.height(8.dp))

        // Button to navigate to the add shift dialog
        Button(onClick = navToAddShift) {
            Text(text = "Create Shift")
        }
    }
}