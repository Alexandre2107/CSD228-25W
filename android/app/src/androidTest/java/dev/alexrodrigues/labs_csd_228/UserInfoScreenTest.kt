package dev.alexrodrigues.labs_csd_228

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.alexrodrigues.labs_csd_228.data.repository.CalendarRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
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
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val calendarRepository = CalendarRepository(shiftRepository)
        val viewModel = MainViewModel(userRepository, shiftRepository, calendarRepository)
        composeTestRule.setContent {
            UserInfoScreen(viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Save").performClick()
    }

    @Test
    fun testUpdateShiftButton() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val calendarRepository = CalendarRepository(shiftRepository)
        val viewModel = MainViewModel(userRepository, shiftRepository, calendarRepository)
        composeTestRule.setContent {
            UserInfoScreen(viewModel = viewModel)
        }

        // Use the unique tag to identify the button
        composeTestRule.onNodeWithTag("UpdateShiftButton_0").performClick()
    }

    @Test
    fun testUpdateShiftButton2() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val calendarRepository = CalendarRepository(shiftRepository)
        val viewModel = MainViewModel(userRepository, shiftRepository, calendarRepository)
        composeTestRule.setContent {
            UserInfoScreen(viewModel = viewModel)
        }

        // Use the unique tag to identify the button
        composeTestRule.onNodeWithTag("UpdateShiftButton_1").performClick()
    }

    @Test
    fun testTextInputs() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val calendarRepository = CalendarRepository(shiftRepository)
        val viewModel = MainViewModel(userRepository, shiftRepository, calendarRepository)
        composeTestRule.setContent {
            UserInfoScreen(viewModel = viewModel)
        }

        // Test name input
        composeTestRule.onNodeWithTag("NameInput").performTextClearance()
        composeTestRule.onNodeWithTag("NameInput").performTextInput("Jane Doe")
        composeTestRule.onNodeWithTag("NameInput").assertTextEquals("Jane Doe")

        // Test email input
        composeTestRule.onNodeWithTag("EmailInput").performTextClearance()
        composeTestRule.onNodeWithTag("EmailInput").performTextInput("jane@example.com")
        composeTestRule.onNodeWithTag("EmailInput").assertTextEquals("jane@example.com")

        // Test phone input
        composeTestRule.onNodeWithTag("PhoneInput").performTextClearance()
        composeTestRule.onNodeWithTag("PhoneInput").performTextInput("123-456-7890")
        composeTestRule.onNodeWithTag("PhoneInput").assertTextEquals("123-456-7890")

        // Test accessibility requirements input
        composeTestRule.onNodeWithTag("AccessibilityRequirementsInput").performTextClearance()
        composeTestRule.onNodeWithTag("AccessibilityRequirementsInput").performTextInput("High Contrast")
        composeTestRule.onNodeWithTag("AccessibilityRequirementsInput").assertTextEquals("High Contrast")
    }
}