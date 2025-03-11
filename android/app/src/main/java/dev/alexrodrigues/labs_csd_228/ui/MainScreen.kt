package dev.alexrodrigues.labs_csd_228.ui

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import dev.alexrodrigues.labs_csd_228.R
import dev.alexrodrigues.labs_csd_228.ui.viewModel.SettingsViewModel
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel

/**
 * Main screen of the app
 *
 * @param darkTheme Boolean indicating if dark theme should be used
 * @param onThemeUpdated Function that updates the theme
 * @param userViewModel The ViewModel for user data
 * @param shiftViewModel The ViewModel for shift data
 * @param settingsViewModel The ViewModel for settings data
 */
@Composable
fun MainScreen(
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    userViewModel: UserViewModel,
    shiftViewModel: ShiftViewModel,
    settingsViewModel: SettingsViewModel,
) {
    // Remember the navigation controller
    val navController = rememberNavController()
    // Column layout to organize items vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        // Display the header
        Header(darkTheme = darkTheme, onThemeUpdated = onThemeUpdated)
        Spacer(modifier = Modifier.height(10.dp))
        // Display the navigation graph
        AppNavGraph(
            navController = navController,
            userViewModel = userViewModel,
            shiftViewModel = shiftViewModel,
            settingsViewModel = settingsViewModel
        )
    }
}

/**
 * Header part of the screen
 *
 * @param darkTheme Boolean indicating if dark theme should be used
 * @param onThemeUpdated Function that updates the theme
 */
@Composable
fun Header(darkTheme: Boolean, onThemeUpdated: () -> Unit) {
    // Choose background color based on the theme
    val backgroundColor = if (darkTheme) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.secondaryContainer
    }

    // A box to hold the header content
    Box(
        modifier = Modifier
            .fillMaxWidth() // Fill the width of the screen
            .background(backgroundColor) // Set background color
            .height(100.dp) // Set height
    ) {
        // Add the header text
        Text(
            text = "App Header",
            fontSize = 24.sp, // Set text size
            textAlign = TextAlign.Start, // Align text to start
            modifier = Modifier
                .padding(start = 10.dp) // Add padding to the start
                .align(Alignment.CenterStart), // Align text to the center start
            color = if (darkTheme) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondaryContainer
        )
        // Add a row to hold the theme switcher
        Row(
            modifier = Modifier
                .fillMaxSize() // Fill the whole box
                .padding(horizontal = 10.dp), // Add horizontal padding
            horizontalArrangement = Arrangement.End, // Arrange items to the end
            verticalAlignment = Alignment.CenterVertically // Align items vertically to the center
        ) {
            Spacer(modifier = Modifier.width(20.dp)) // Add some space
            // Add the theme switcher
            ThemeSwitcher(
                darkTheme = darkTheme,
                onClick = onThemeUpdated,
            )
        }
    }
}

/**
 * Theme switcher button.
 *
 * @param darkTheme Boolean indicating if dark theme should be used
 * @param size Size of the switcher
 * @param iconSize Size of the icons
 * @param padding Padding inside the switcher
 * @param borderWidth Width of the border
 * @param parentShape Shape of the parent container
 * @param toggleShape Shape of the toggle
 * @param animationSpec Animation specification for the toggle
 * @param onClick Callback function to handle click events
 */
@Composable
fun ThemeSwitcher(
    darkTheme: Boolean = false,
    size: Dp = 50.dp,
    iconSize: Dp = size / 2,
    padding: Dp = 10.dp,
    borderWidth: Dp = 1.dp,
    parentShape: Shape = CircleShape,
    toggleShape: Shape = CircleShape,
    animationSpec: AnimationSpec<Dp> = tween(durationMillis = 300),
    onClick: () -> Unit
) {
    // Animate the switcher position
    val offset by animateDpAsState(
        targetValue = if (darkTheme) 0.dp else size,
        animationSpec = animationSpec
    )

    // A box to hold the switcher
    Box(modifier = Modifier
        .width(size * 2) // Set width
        .height(size) // Set height
        .clip(shape = parentShape) // Clip to shape
        .clickable { onClick() } // Make it clickable
        .background(MaterialTheme.colorScheme.secondaryContainer) // Set background color
    ) {
        // A box for the toggle
        Box(
            modifier = Modifier
                .size(size) // Set size
                .offset { IntOffset(x = offset.roundToPx(), y = 0) } // Set offset using lambda overload
                .padding(all = padding) // Add padding
                .clip(shape = toggleShape) // Clip to shape
                .background(MaterialTheme.colorScheme.primary) // Set background color
        ) {}
        // A row to hold the icons
        Row(
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = borderWidth, // Set border width
                        color = MaterialTheme.colorScheme.primary // Set border color
                    ),
                    shape = parentShape // Set shape
                )
        ) {
            // Box for the dark mode icon
            Box(
                modifier = Modifier.size(size), // Set size
                contentAlignment = Alignment.Center // Align content to center
            ) {
                Icon(
                    modifier = Modifier.size(iconSize), // Set icon size
                    painter = painterResource(id = R.drawable.dark_mode), // Set icon resource
                    contentDescription = "Dark Mode Icon", // Set content description
                    tint = if (darkTheme) MaterialTheme.colorScheme.secondaryContainer
                    else MaterialTheme.colorScheme.primary
                )
            }
            // Box for the light mode icon
            Box(
                modifier = Modifier.size(size), // Set size
                contentAlignment = Alignment.Center // Align content to center
            ) {
                Icon(
                    modifier = Modifier.size(iconSize), // Set icon size
                    painter = painterResource(id = R.drawable.light_mode_24dp_e8eaed_fill0_wght400_grad0_opsz24), // Set icon resource
                    contentDescription = "Light Mode Icon", // Set content description
                    tint = if (darkTheme) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.secondaryContainer
                )
            }
        }
    }
}