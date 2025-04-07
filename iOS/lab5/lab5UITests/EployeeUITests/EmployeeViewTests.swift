//
//  EmployeeViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//


import XCTest
@testable import lab5

class EmployeeViewTests: XCTestCase {
    var employeeRepository: EmployeeRepository!

    override func setUp() {
        super.setUp()
        employeeRepository = EmployeeRepository()
    }

    override func tearDown() {
        employeeRepository = nil
        super.tearDown()
    }

    func testEmployeeInitialization() {
        let employee = Employee(name: "Test Employee", position: "Tester")
        XCTAssertEqual(employee.name, "Test Employee")
        XCTAssertEqual(employee.position, "Tester")
    }

    func testEmployeeRepositoryInitialization() {
        XCTAssertEqual(employeeRepository.employees.count, 2)
    }
}
