/*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dev.alexrodrigues.labs_csd_228.ui.page.shifts.CreateShiftDialog
import org.junit.Rule
import org.junit.Test

class CreateShiftDialogTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCreateShiftDialog() {
        var dialogDismissed = false

        composeTestRule.setContent {
            CreateShiftDialog(popBackStack = { dialogDismissed = true })
        }

        // Verify the dialog title
        composeTestRule.onNodeWithText("Create Shift").assertExists()

        // Verify the confirm button and perform click
        composeTestRule.onNodeWithText("Create").assertExists().performClick()
        assert(dialogDismissed)

        // Reset the flag
        dialogDismissed = false

        // Verify the dismiss button and perform click
        composeTestRule.onNodeWithText("Cancel").assertExists().performClick()
        assert(dialogDismissed)
    }
}*/
