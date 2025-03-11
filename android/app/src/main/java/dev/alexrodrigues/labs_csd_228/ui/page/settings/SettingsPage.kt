package dev.alexrodrigues.labs_csd_228.ui.page.settings

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.alexrodrigues.labs_csd_228.ui.viewModel.SettingsViewModel

/**
 * Displays the settings page
 *
 * @param popBackStack The function to pop the back stack
 * @param navigateToShifts The function to navigate to the shifts page
 * @param navigateToEmployees The function to navigate to the employees page
 */
@Composable
fun SettingsPage(
    popBackStack: () -> Unit = {},
    navigateToShifts: () -> Unit = {},
    navigateToEmployees: () -> Unit = {},
) {
    Column(modifier = Modifier.padding(10.dp).fillMaxSize()) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            // Button to navigate to the shifts page
            Button(onClick = navigateToShifts) {
                Text(text = "Go to Shifts")
            }
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            // Button to navigate to the employees page
            Button(onClick = navigateToEmployees) {
                Text(text = "Go to Employees")
            }
        }
        // Display the settings page title
        Text(text = "Settings Page", color = MaterialTheme.colorScheme.onSurface)
    }
}