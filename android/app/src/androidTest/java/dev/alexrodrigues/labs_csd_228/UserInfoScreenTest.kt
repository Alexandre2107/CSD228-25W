package dev.alexrodrigues.labs_csd_228

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.alexrodrigues.labs_csd_228.ui.MainViewModel
import dev.alexrodrigues.labs_csd_228.ui.UserInfoScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserInfoScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSaveButton() {
        composeTestRule.setContent {
            UserInfoScreen(viewModel = viewModel())
        }

        composeTestRule.onNodeWithText("Save").performClick()
    }

    @Test
    fun testUpdateShiftButton() {
        composeTestRule.setContent {
            UserInfoScreen(viewModel = viewModel())
        }

        composeTestRule.onNodeWithText("Update Shift").performClick()
    }
}