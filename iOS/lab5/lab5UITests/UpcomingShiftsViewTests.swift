//
//  UpcomingShiftsViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
@testable import lab5

class UpcomingShiftsViewTests: XCTestCase {
    var shiftRepository: ShiftRepository!

    override func setUp() {
        super.setUp()
        shiftRepository = ShiftRepository()
    }

    override func tearDown() {
        shiftRepository = nil
        super.tearDown()
    }

    func testUpcomingShiftsView() {
        let view = UpcomingShiftsView(shifts: shiftRepository.shifts)
        XCTAssertEqual(view.shifts.count, 2)
    }
}
