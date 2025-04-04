//
//  File.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 02/04/25.
//

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

    /// Initializes a new employee with the given name and position
    ///   - Parameters:
    ///   - name: The name of the employee
    ///   - position: The position of the employee
    init(name: String, position: String) {
        self.name = name
        self.position = position
    }
}

/// Class that manages a collection of employees
class EmployeeRepository: ObservableObject {
    /// An array of employees
    @Published var employees: [Employee] = []

    /// Initializes the repository with some test data
    init() {
        employees = [
            Employee(name: "John Doe", position: "Manager"),
            Employee(name: "Jane Smith", position: "Developer")
        ]
    }
}

