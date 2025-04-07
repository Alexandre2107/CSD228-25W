//
//  EmployeeDetailViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
import SwiftUI
@testable import lab5

class EmployeeDetailViewTests: XCTestCase {
    var employee: Employee!

    override func setUp() {
        super.setUp()
        employee = Employee(name: "Test Employee", position: "Tester", shift: Shift(date: Date(), duration: 3600))
    }

    override func tearDown() {
        employee = nil
        super.tearDown()
    }

    func testEmployeeDetailView() {
        let view = EmployeeDetailView(employee: employee)
        XCTAssertNotNil(view)
    }
}
