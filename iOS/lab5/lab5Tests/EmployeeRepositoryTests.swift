//
//  EmployeeRepositoryTests.swift
//  lab5Tests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
@testable import lab5

final class EmployeeRepositoryTests: XCTestCase {
    var employeeRepository: EmployeeRepository!

    override func setUpWithError() throws {
        employeeRepository = EmployeeRepository()
    }

    override func tearDownWithError() throws {
        employeeRepository = nil
    }

    func testInitialEmployeesCount() throws {
        XCTAssertEqual(employeeRepository.employees.count, 2, "Initial employees count should be 2")
    }

    func testAddEmployee() throws {
        let newEmployee = Employee(name: "Alice Johnson", position: "Designer")
        employeeRepository.employees.append(newEmployee)
        XCTAssertEqual(employeeRepository.employees.count, 3, "Employees count should be 3 after adding a new employee")
    }
}
