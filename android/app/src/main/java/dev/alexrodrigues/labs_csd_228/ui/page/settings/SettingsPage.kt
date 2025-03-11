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
 * @param navController The NavHostController used for navigation
 * @param settingsViewModel The ViewModel that provides the settings data
 */
@Composable
fun SettingsPage(navController: NavHostController, settingsViewModel: SettingsViewModel) {
    Column(modifier = Modifier.padding(10.dp).fillMaxSize()) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            // Button to navigate to the shifts page
            Button(onClick = { navController.navigate("shifts") }) {
                Text(text = "Go to Shifts")
            }
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            // Button to navigate to the employees page
            Button(onClick = { navController.navigate("employees") }) {
                Text(text = "Go to Employees")
            }
        }
        // Display the settings page title
        Text(text = "Settings Page", color = MaterialTheme.colorScheme.onSurface)
    }
}