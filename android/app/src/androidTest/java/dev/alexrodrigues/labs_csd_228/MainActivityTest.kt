package dev.alexrodrigues.labs_csd_228

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testMainScreen() {
        // Use the existing content set by MainActivity
        composeTestRule.onNodeWithText("App Header").assertExists()
        composeTestRule.onNodeWithText("User Information").assertExists()
    }
}