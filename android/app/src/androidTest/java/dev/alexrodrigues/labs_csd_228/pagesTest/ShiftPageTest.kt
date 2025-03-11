package dev.alexrodrigues.labs_csd_228.pagesTest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.ui.page.shifts.ShiftsPage
import dev.alexrodrigues.labs_csd_228.ui.viewModel.ShiftViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class ShiftsPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavHostController

    @Test
    fun testShiftsPageDisplaysCorrectly() {
        val shiftRepository = ShiftRepository()
        val shiftViewModel = ShiftViewModel(shiftRepository)

        composeTestRule.setContent {
            navController = rememberNavController()
            ShiftsPage(
                viewModel = shiftViewModel
            )
        }

        composeTestRule.onNodeWithText("Go to Settings").assertExists()
        composeTestRule.onNodeWithText("Go to Employees").assertExists()
    }

    @Test
    fun testNavigateToSettings() {
        val shiftRepository = ShiftRepository()
        val shiftViewModel = ShiftViewModel(shiftRepository)
        var navigateToShiftsCalled = false

        composeTestRule.setContent {
            ShiftsPage(
                navigateToShifts = { navigateToShiftsCalled = true },
                viewModel = shiftViewModel
            )
        }

        composeTestRule.onNodeWithText("Go to Settings").assertExists().performClick()
        assert(navigateToShiftsCalled)
    }

    @Test
    fun testNavigateToEmployees() {
        val shiftRepository = ShiftRepository()
        val shiftViewModel = ShiftViewModel(shiftRepository)
        var navigateToEmployeesCalled = false

        composeTestRule.setContent {
            ShiftsPage(
                navigateToEmployees = { navigateToEmployeesCalled = true },
                viewModel = shiftViewModel
            )
        }

        composeTestRule.onNodeWithText("Go to Employees").assertExists().performClick()
        assert(navigateToEmployeesCalled)
    }

    @Test
    fun testNavigateToCreateShift() {
        val shiftRepository = ShiftRepository()
        val shiftViewModel = ShiftViewModel(shiftRepository)
        var navigateToCreateShiftCalled = false

        composeTestRule.setContent {
            ShiftsPage(
                navToAddShift = { navigateToCreateShiftCalled = true },
                viewModel = shiftViewModel
            )
        }

        composeTestRule.onNodeWithText("Create Shift").assertExists().performClick()
        assert(navigateToCreateShiftCalled)
    }

    @Test
    fun testNavigateToShiftDetails() {
        val shiftRepository = ShiftRepository()
        val shiftViewModel = ShiftViewModel(shiftRepository)
        var navigateToShiftDetailsCalled = false

        composeTestRule.setContent {

            ShiftsPage(
                onSelectShift = { navigateToShiftDetailsCalled = true },
                viewModel = shiftViewModel
            )
        }

        composeTestRule.onNodeWithText("Go to Shift Details_shift1").assertExists().performClick()
        assert(navigateToShiftDetailsCalled)
    }
}