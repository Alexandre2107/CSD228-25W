//
//  EmployeeListViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
import SwiftUI
@testable import lab5

class EmployeesListViewTests: XCTestCase {
    var employeeRepository: EmployeeRepository!

    override func setUp() {
        super.setUp()
        employeeRepository = EmployeeRepository()
    }

    override func tearDown() {
        employeeRepository = nil
        super.tearDown()
    }

    func testEmployeesListView() {
        let view = EmployeesListView()
        XCTAssertNotNil(view)
    }
}
