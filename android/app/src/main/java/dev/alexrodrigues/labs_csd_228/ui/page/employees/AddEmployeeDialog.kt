package dev.alexrodrigues.labs_csd_228.ui.page.employees

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.material3.*
import dev.alexrodrigues.labs_csd_228.data.entities.UserEntity
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel

/**
 * Dialog to add a new employee
 * @param popBackStack Function to close the dialog
 * @param viewModel The ViewModel to handle user data
 */
@Composable
fun AddEmployeeDialog(
    popBackStack: () -> Unit = {},
    viewModel: UserViewModel
) {
    // State variables to hold the input values
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var accessibilityRequirements by remember { mutableStateOf("") }

    // AlertDialog to add a new employee
    AlertDialog(
        onDismissRequest = popBackStack,
        title = { Text(text = "Add Employee") },
        text = {
            Column {
                // TextFields for user input
                TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
                TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
                TextField(value = phone, onValueChange = { phone = it }, label = { Text("Phone") })
                TextField(value = accessibilityRequirements, onValueChange = { accessibilityRequirements = it }, label = { Text("Accessibility Requirements") })
            }
        },
        confirmButton = {
            // Button to add the employee
            Button(onClick = {
                viewModel.insertUser(UserEntity(
                    id = "", // ID will be generated in the ViewModel
                    name = name,
                    email = email,
                    phone = phone,
                    accessibilityRequirements = accessibilityRequirements
                ))
                popBackStack()
            }) {
                Text("Add")
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