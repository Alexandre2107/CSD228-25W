import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.ui.page.employees.EmployeeDetailsPage
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel
import org.junit.Rule
import org.junit.Test

class EmployeeDetailsPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testEmployeeDetailsPage() {
        val userViewModel = UserViewModel(
            userRepository = UserRepository(),
            shiftRepository = ShiftRepository()
        )
        val employeeId = "user1"

        composeTestRule.setContent {
            EmployeeDetailsPage(
                popBackStack = {},
                employeeId = employeeId,
                navigateToEmployees = {},
                viewModel = userViewModel
            )
        }

        // Verify the employee details
        composeTestRule.onNodeWithText("Employee Details").assertExists()
        composeTestRule.onNodeWithText("ID: $employeeId").assertExists()
        composeTestRule.onNodeWithText("Name: John Doe").assertExists()
        composeTestRule.onNodeWithText("Email: john@example.com").assertExists()
        composeTestRule.onNodeWithText("Phone: 123-456-7890").assertExists()

        // Verify the shifts
        composeTestRule.onNodeWithText("Shift ID: shift1").assertExists()
        composeTestRule.onNodeWithText("Location: Office").assertExists()
        composeTestRule.onNodeWithText("Description: Morning Shift").assertExists()
    }
}