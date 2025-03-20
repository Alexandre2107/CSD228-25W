/*
package dev.alexrodrigues.labs_csd_228.pagesTest

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import dev.alexrodrigues.labs_csd_228.data.repository.UserRepository
import dev.alexrodrigues.labs_csd_228.data.repository.ShiftRepository
import dev.alexrodrigues.labs_csd_228.ui.page.employees.EmployeesPage
import dev.alexrodrigues.labs_csd_228.ui.viewModel.UserViewModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class EmployeesPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: NavHostController

    @Test
    fun testEmployeesPageDisplaysCorrectly() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)

        composeTestRule.setContent {
            navController = rememberNavController()
            EmployeesPage(
                viewModel = userViewModel
            )
        }

        composeTestRule.onNodeWithTag("GoToSettingsButton").assertExists()
        composeTestRule.onNodeWithTag("GoToShiftsButton").assertExists()
        composeTestRule.onNodeWithTag("AddEmployeeButton").assertExists()
    }

    @Test
    fun testNavigateToSettings() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        var navigateToSettingsCalled = false

        composeTestRule.setContent {
            EmployeesPage(
                navigateToSettings = { navigateToSettingsCalled = true },
                viewModel = userViewModel
            )
        }

        composeTestRule.onNodeWithTag("GoToSettingsButton").performClick()
        assert(navigateToSettingsCalled)
    }

    @Test
    fun testNavigateToShifts() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        var navigateToShiftsCalled = false

        composeTestRule.setContent {
            EmployeesPage(
                navigateToShifts = { navigateToShiftsCalled = true },
                viewModel = userViewModel
            )
        }

        composeTestRule.onNodeWithTag("GoToShiftsButton").performClick()
        assert(navigateToShiftsCalled)
    }

    @Test
    fun testNavigateToAddEmployee() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        var navigateToAddEmployeeCalled = false

        composeTestRule.setContent {
            EmployeesPage(
                navToAddEmployee = { navigateToAddEmployeeCalled = true },
                viewModel = userViewModel
            )
        }

        composeTestRule.onNodeWithTag("AddEmployeeButton").performClick()
        assert(navigateToAddEmployeeCalled)
    }

    @Test
    fun testNavigateToUser1Details() {
        val userRepository = UserRepository()
        val shiftRepository = ShiftRepository()
        val userViewModel = UserViewModel(userRepository, shiftRepository)
        var navigateToUser1DetailsCalled = false

        composeTestRule.setContent {
            EmployeesPage(
                onSelectUser = { navigateToUser1DetailsCalled = true },
                viewModel = userViewModel
            )
        }

        composeTestRule.onNodeWithText("Go to Employee Details_user1").performClick()
        assert(navigateToUser1DetailsCalled)
    }
}*/
