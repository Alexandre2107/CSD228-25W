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
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alexrodrigues.labs_csd_228.data.User
import dev.alexrodrigues.labs_csd_228.data.Shift

/**
 * Function to display and update user information
 *
 * @param viewModel The ViewModel for managing UI-related data
 */
@Composable
fun UserInfoScreen(viewModel: MainViewModel = viewModel()) {
    val user by viewModel.user.collectAsState()
    val shifts by viewModel.shifts.collectAsState()
    val calendar by viewModel.calendar.collectAsState()

    var name by remember { mutableStateOf(user?.name ?: "") }
    var email by remember { mutableStateOf(user?.email ?: "") }
    var phone by remember { mutableStateOf(user?.phone ?: "") }
    var accessibilityRequirements by remember { mutableStateOf(user?.accessibilityRequirements?.joinToString(", ") ?: "") }

    var oldUser by remember { mutableStateOf(user) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Display user information header
        Text("User Information", style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)

        // Input field for user name
        BasicTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
        )

        // Input field for user email
        BasicTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
        )

        // Input field for user phone
        BasicTextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
        )

        // Input field for user accessibility requirements
        BasicTextField(
            value = accessibilityRequirements,
            onValueChange = { accessibilityRequirements = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
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

        // Display old user information
        Text("Old User Information", style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)
        user?.let {
            Text("Name: ${it.name}", color = MaterialTheme.colorScheme.onSurface)
            Text("Email: ${it.email}", color = MaterialTheme.colorScheme.onSurface)
            Text("Phone: ${it.phone}", color = MaterialTheme.colorScheme.onSurface)
            Text("Accessibility Requirements: ${it.accessibilityRequirements.joinToString(", ")}", color = MaterialTheme.colorScheme.onSurface)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display shifts information
        Text("Shifts Information", style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)
        shifts.forEach { shift ->
            var shiftLocation by remember { mutableStateOf(shift.location) }
            var shiftDescription by remember { mutableStateOf(shift.description) }

            Column(modifier = Modifier.padding(8.dp)) {
                Text("Shift ID: ${shift.id}", color = MaterialTheme.colorScheme.onSurface)

                // Input field for shift location
                BasicTextField(
                    value = shiftLocation,
                    onValueChange = { shiftLocation = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, Color.Gray)
                        .padding(8.dp),
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
                )

                // Input field for shift description
                BasicTextField(
                    value = shiftDescription,
                    onValueChange = { shiftDescription = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(1.dp, Color.Gray)
                        .padding(8.dp),
                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurface)
                )

                // Button to update shift information
                Button(onClick = {
                    viewModel.updateShift(Shift(shift.id, shift.userId, shift.startTime, shift.endTime, shiftLocation, shiftDescription))
                }) {
                    Text("Update Shift", color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display calendar information
        Text("Calendar Information", style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.onSurface)
        calendar?.shiftsByDate?.forEach { (date, shifts) ->
            Text("Date: $date", color = MaterialTheme.colorScheme.onSurface)
            shifts.forEach { shift ->
                Text("Shift ID: ${shift.id}, Location: ${shift.location}, Description: ${shift.description}", color = MaterialTheme.colorScheme.onSurface)
            }
        }
    }
}