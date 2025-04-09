/*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dev.alexrodrigues.labs_csd_228.ui.page.employees.AddEmployeeDialog
import org.junit.Rule
import org.junit.Test

class AddEmployeeDialogTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAddEmployeeDialog() {
        var dialogDismissed = false

        composeTestRule.setContent {
            AddEmployeeDialog(popBackStack = { dialogDismissed = true })
        }


        composeTestRule.onNodeWithText("Add Employee").assertExists()

        // Verify the confirm button and perform click
        composeTestRule.onNodeWithText("Add").assertExists().performClick()
        assert(dialogDismissed)

        // Reset the flag
        dialogDismissed = false

        // Verify the dismiss button and perform click
        composeTestRule.onNodeWithText("Cancel").assertExists().performClick()
        assert(dialogDismissed)
    }
}*/
