import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dev.alexrodrigues.labs_csd_228.ui.page.settings.SettingsPage
import org.junit.Rule
import org.junit.Test

class SettingsPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSettingsPage() {
        var navigateToShiftsCalled = false
        var navigateToEmployeesCalled = false

        composeTestRule.setContent {
            SettingsPage(
                navigateToShifts = { navigateToShiftsCalled = true },
                navigateToEmployees = { navigateToEmployeesCalled = true }
            )
        }


        composeTestRule.onNodeWithText("Settings Page").assertExists()


        composeTestRule.onNodeWithText("Go to Shifts").assertExists().performClick()
        assert(navigateToShiftsCalled)


        composeTestRule.onNodeWithText("Go to Employees").assertExists().performClick()
        assert(navigateToEmployeesCalled)
    }
}