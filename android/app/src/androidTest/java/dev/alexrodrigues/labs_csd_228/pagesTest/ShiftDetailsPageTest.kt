/*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.ui.page.shifts.ShiftDetailsPage
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel
import org.junit.Rule
import org.junit.Test

class ShiftDetailsPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testShiftDetailsPage() {
        val shiftViewModel = ShiftViewModel(ShiftRepository())
        val shiftId = "shift1"

        composeTestRule.setContent {
            ShiftDetailsPage(
                popBackStack = {},
                shiftId = shiftId,
                navigateToShifts = {},
                viewModel = shiftViewModel
            )
        }

        // Verify the shift details
        composeTestRule.onNodeWithText("Shift Details").assertExists()
        composeTestRule.onNodeWithText("ID: $shiftId").assertExists()
        composeTestRule.onNodeWithText("Location: Office").assertExists()
        composeTestRule.onNodeWithText("Description: Morning Shift").assertExists()
    }
}*/
