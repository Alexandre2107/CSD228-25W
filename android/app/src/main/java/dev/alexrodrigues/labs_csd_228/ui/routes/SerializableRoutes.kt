import kotlinx.serialization.Serializable

// Serializable object for the settings route
@Serializable
data object SettingsRoute

// Serializable object for the shifts route
@Serializable
data object ShiftsRoute

// Serializable data class for the shift details route with a shift ID
@Serializable
data class ShiftDetailsRoute(val shiftId: String)

// Serializable object for the create shift route
@Serializable
data object CreateShiftRoute

// Serializable object for the employees route
@Serializable
data object EmployeesRoute

// Serializable data class for the employee details route with an employee ID
@Serializable
data class EmployeeDetailsRoute(val employeeId: String)

// Serializable object for the add employee route
@Serializable
data object AddEmployeeRoute