//
//  File.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 02/04/25.
//

import Foundation
import Combine

import Foundation
import Combine

/// Class representing an employee.
class Employee: Identifiable, ObservableObject {
    /// ID for the employee
    let id = UUID()
    /// Name of the employee
    @Published var name: String
    /// Position of the employee
    @Published var position: String
    /// Shift assigned to the employee
    @Published var shift: Shift?

    /// Initializes a new employee with the given name, position, and shift
    ///   - Parameters:
    ///   - name: The name of the employee
    ///   - position: The position of the employee
    ///   - shift: The shift assigned to the employee
    init(name: String, position: String, shift: Shift? = nil) {
        self.name = name
        self.position = position
        self.shift = shift
    }
}

/// Manages a collection of employees
class EmployeeRepository: ObservableObject {
    /// An array of employees
    @Published var employees: [Employee] = []

    /// Initializes the repository with some test data
    init() {
        // Create some shifts
        let shift1 = Shift(date: Date(), duration: 3600)
        let shift2 = Shift(date: Date().addingTimeInterval(86400), duration: 7200)

        // Assign shifts to employees
        employees = [
            Employee(name: "John Doe", position: "Manager", shift: shift1),
            Employee(name: "Jane Smith", position: "Developer", shift: shift2)
        ]
    }
}

