package dev.alexrodrigues.labs_csd_228.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alexrodrigues.labs_csd_228.data.User
import dev.alexrodrigues.labs_csd_228.data.Shift

/**
 * Function to display user information and shifts
 *
 * @param viewModel The ViewModel that provides user and shift data
 */
@Composable
fun UserInfoScreen(viewModel: MainViewModel = viewModel()) {
    // Collecting state from the ViewModel
    val user by viewModel.user.collectAsState()
    val shifts by viewModel.shifts.collectAsState()
    val calendar by viewModel.calendar.collectAsState()

    // Mutable states for user information
    var name by remember { mutableStateOf(user?.name ?: "") }
    var email by remember { mutableStateOf(user?.email ?: "") }
    var phone by remember { mutableStateOf(user?.phone ?: "") }
    var accessibilityRequirements by remember { mutableStateOf(user?.accessibilityRequirements?.joinToString(", ") ?: "") }

    var oldUser by remember { mutableStateOf(user) }

    // Column layout to organize items vertically
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Enable vertical scrolling
    ) {
        // Displaying user information header
        Text("User Information", style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)

        // Text field for name input
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
                .testTag("NameInput"), // Tag for testing
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
        )

        // Text field for email input
        BasicTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
                .testTag("EmailInput"), // Tag for testing
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
        )

        // Text field for phone input
        BasicTextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
                .testTag("PhoneInput"), // Tag for testing
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
        )

        // Text field for accessibility requirements input
        BasicTextField(
            value = accessibilityRequirements,
            onValueChange = { accessibilityRequirements = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp)
                .testTag("AccessibilityRequirementsInput"), // Tag for testing
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
        )

        // Button to save user information
        Button(onClick = {
            oldUser = user
            viewModel.updateUser(User(user!!.id, name, email, phone, accessibilityRequirements.split(", ")))
        }) {
            Text("Save", color = MaterialTheme.colorScheme.onPrimary)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Displaying old user information
        Text("Old User Information", style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)
        user?.let {
            Text("Name: ${it.name}", color = MaterialTheme.colorScheme.onSurface)
            Text("Email: ${it.email}", color = MaterialTheme.colorScheme.onSurface)
            Text("Phone: ${it.phone}", color = MaterialTheme.colorScheme.onSurface)
            Text("Accessibility Requirements: ${it.accessibilityRequirements.joinToString(", ")}", color = MaterialTheme.colorScheme.onSurface)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Displaying shifts information
        Text("Shifts Information", style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)
        shifts.forEachIndexed { index, shift ->
            var shiftLocation by remember { mutableStateOf(shift.location) }
            var shiftDescription by remember { mutableStateOf(shift.description) }

            Column(modifier = Modifier.padding(8.dp)) {
                Text("Shift ID: ${shift.id}", color = MaterialTheme.colorScheme.onSurface)

                // Text field for shift location input
                BasicTextField(
                    value = shiftLocation,
                    onValueChange = { shiftLocation = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, Color.Gray)
                        .padding(8.dp)
                        .testTag("ShiftLocationInput_$index"), // Tag for testing
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
                )

                // Text field for shift description input
                BasicTextField(
                    value = shiftDescription,
                    onValueChange = { shiftDescription = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, Color.Gray)
                        .padding(8.dp)
                        .testTag("ShiftDescriptionInput_$index"), // Tag for testing
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
                )

                // Button to update shift information
                Button(
                    onClick = {
                        viewModel.updateShift(Shift(shift.id, shift.userId, shift.startTime, shift.endTime, shiftLocation, shiftDescription))
                    },
                    modifier = Modifier.testTag("UpdateShiftButton_$index") // Tag for testing
                ) {
                    Text("Update Shift", color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Displaying calendar information
        Text("Calendar Information", style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)
        calendar?.shiftsByDate?.forEach { (date, shifts) ->
            Text("Date: $date", color = MaterialTheme.colorScheme.onSurface)
            shifts.forEach { shift ->
                Text("Shift ID: ${shift.id}, Location: ${shift.location}, Description: ${shift.description}", color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}