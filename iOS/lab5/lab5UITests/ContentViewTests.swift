//
//  ContentViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
@testable import lab5

class ContentViewTests: XCTestCase {
    var settings: Settings!
    var shiftRepository: ShiftRepository!
    var employeeRepository: EmployeeRepository!

    override func setUp() {
        super.setUp()
        settings = Settings()
        shiftRepository = ShiftRepository()
        employeeRepository = EmployeeRepository()
    }

    override func tearDown() {
        settings = nil
        shiftRepository = nil
        employeeRepository = nil
        super.tearDown()
    }

    func testContentView() {
        let view = ContentView()
        XCTAssertNotNil(view)
    }
}
