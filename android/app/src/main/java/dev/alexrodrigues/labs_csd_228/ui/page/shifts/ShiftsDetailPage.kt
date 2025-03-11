package dev.alexrodrigues.labs_csd_228.ui.page.shifts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel

/**
 * Displays the details of a specific shift
 *
 * @param navController The NavHostController used for navigation
 * @param shiftId The ID of the shift whose details are to be displayed
 * @param viewModel The ViewModel that provides the shift data
 */
@Composable
fun ShiftDetailsPage(
    navController: NavHostController,
    shiftId: String?,
    viewModel: ShiftViewModel,
) {
    // Collect the list of shifts from the ViewModel
    val shift = viewModel.shifts.collectAsState().value.find { it.id == shiftId }

    Column(modifier = Modifier.padding(16.dp)) {
        // Button to navigate back to the shifts list
        Button(onClick = { navController.navigate("shifts") }) {
            Text(text = "Go back to Shift Page")
        }
        shift?.let {
            // Display shift details
            Text(text = "Shift Details", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "ID: ${it.id}", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "Location: ${it.location}", color = MaterialTheme.colorScheme.onSurface)
            Text(text = "Description: ${it.description}", color = MaterialTheme.colorScheme.onSurface)
        } ?: run {
            // Display message if shift is not found
            Text(text = "Shift not found", color = MaterialTheme.colorScheme.onSurface)
        }
    }
}