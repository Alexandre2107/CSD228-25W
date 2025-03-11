import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import dev.alexrodrigues.labs_csd_228.data.repository.SettingsRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.ui.MainScreen
import dev.alexrodrigues.labs_csd_228.ui.viewModel.SettingsViewModel
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMainScreenDisplaysHeader() {
        val userViewModel = UserViewModel(UserRepository(), ShiftRepository())
        val shiftViewModel = ShiftViewModel(ShiftRepository())
        val settingsViewModel = SettingsViewModel(SettingsRepository())

        composeTestRule.setContent {
            MainScreen(
                darkTheme = false,
                onThemeUpdated = {},
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        composeTestRule.onNodeWithText("App Header").assertExists()
    }

    @Test
    fun testThemeSwitcherClick() {
        val userViewModel = UserViewModel(UserRepository(), ShiftRepository())
        val shiftViewModel = ShiftViewModel(ShiftRepository())
        val settingsViewModel = SettingsViewModel(SettingsRepository())
        var themeUpdated = false

        composeTestRule.setContent {
            MainScreen(
                darkTheme = false,
                onThemeUpdated = { themeUpdated = true },
                userViewModel = userViewModel,
                shiftViewModel = shiftViewModel,
                settingsViewModel = settingsViewModel
            )
        }

        composeTestRule.onNodeWithContentDescription("Light Mode Icon").assertExists().performClick()
        assert(themeUpdated)
    }
}