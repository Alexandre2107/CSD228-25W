package dev.alexrodrigues.labs_csd_228.ui.page.shifts

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.material3.*
import dev.alexrodrigues.labs_csd_228.data.entities.ShiftEntity
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel
import java.time.Instant

/**
 * Dialog to create a new shift
 * @param popBackStack Function to close the dialog
 * @param viewModel The ViewModel to handle shift data
 */
@Composable
fun CreateShiftDialog(
    popBackStack: () -> Unit = {},
    viewModel: ShiftViewModel
) {
    // State variables to hold the input values
    var userId by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    // AlertDialog to create a new shift
    AlertDialog(
        onDismissRequest = popBackStack,
        title = { Text(text = "Create Shift") },
        text = {
            Column {
                // TextFields for user input
                TextField(value = userId, onValueChange = { userId = it }, label = { Text("User ID") })
                TextField(value = location, onValueChange = { location = it }, label = { Text("Location") })
                TextField(value = description, onValueChange = { description = it }, label = { Text("Description") })
            }
        },
        confirmButton = {
            // Button to create the shift
            Button(onClick = {
                viewModel.insertShift(ShiftEntity(
                    id = "", // ID will be generated in the ViewModel
                    userId = userId,
                    startTime = Instant.now().toEpochMilli(),
                    endTime = Instant.now().plusSeconds(3600).toEpochMilli(),
                    location = location,
                    description = description
                ))
                popBackStack()
            }) {
                Text("Create")
            }
        },
        dismissButton = {
            // Button to cancel the dialog
            Button(onClick = popBackStack) {
                Text("Cancel")
            }
        }
    )
}