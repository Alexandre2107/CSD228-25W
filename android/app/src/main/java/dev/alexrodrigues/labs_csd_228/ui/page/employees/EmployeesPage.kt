package dev.alexrodrigues.labs_csd_228.ui.page.employees

import android.util.Log
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel
import kotlin.math.log

/**
 * Displays the list of employees
 *
 * @param popBackStack The function to pop the back stack
 * @param onSelectUser The function to navigate to the details of a specific employee
 * @param navigateToShifts The function to navigate to the shifts list
 * @param navigateToSettings The function to navigate to the settings page
 * @param navToAddEmployee The function to navigate to the add employee dialog
 * @param viewModel The ViewModel that provides the employee data
 */
@Composable
fun EmployeesPage(
    popBackStack: () -> Unit = {},
    onSelectUser: (String) -> Unit = {},
    navigateToShifts: () -> Unit = {},
    navigateToSettings: () -> Unit = {},
    navToAddEmployee: () -> Unit = {},
    viewModel: UserViewModel,
) {
    // Collect the list of users from the ViewModel
    val users by viewModel.users.collectAsState()

    // Create a column layout with padding and fill the available size
    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {

        // Create a row layout to hold the navigation buttons
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            // Button to navigate to the settings page
            Button(onClick = navigateToSettings, modifier = Modifier.testTag("GoToSettingsButton")) {
                Text(text = "Go to Settings")
            }
            // Spacer to add horizontal space between buttons
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            // Button to navigate to the shifts page
            Button(onClick = navigateToShifts, modifier = Modifier.testTag("GoToShiftsButton")) {
                Text(text = "Go to Shifts")
            }
        }

        // Spacer to add vertical space
        Spacer(modifier = Modifier.height(8.dp))

        // Text to display the title of the employees list
        Text(text = "Employees List", color = MaterialTheme.colorScheme.onSurface)

        // Loop through the list of users and display their details
        users.forEach { user ->
            // Display the user's name, email, and phone
            Text(text = "Name: ${user.name}, Email: ${user.email}, Phone: ${user.phone}", color = MaterialTheme.colorScheme.onSurface)
            // Spacer to add vertical space between user details and button
            Spacer(modifier = Modifier.height(8.dp))
            // Button to navigate to the details of the selected employee
            Button(onClick = { onSelectUser(user.id) }, modifier = Modifier.testTag("GoToEmployeeDetailsButton_${user.id}")) {
                Text(text = "Go to Employee Details_${user.id}")
            }
        }

        // Spacer to add vertical space
        Spacer(modifier = Modifier.height(8.dp))

        // Button to navigate to the add employee dialog
        Button(onClick = navToAddEmployee, modifier = Modifier.testTag("AddEmployeeButton")) {
            Text(text = "Add Employee")
        }
    }
}
