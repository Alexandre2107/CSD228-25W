//
//  ShiftRepositoryTests.swift
//  lab5Tests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
@testable import lab5

final class ShiftRepositoryTests: XCTestCase {
    var shiftRepository: ShiftRepository!

    override func setUpWithError() throws {
        shiftRepository = ShiftRepository()
    }

    override func tearDownWithError() throws {
        shiftRepository = nil
    }

    func testInitialShiftsCount() throws {
        XCTAssertEqual(shiftRepository.shifts.count, 2, "Initial shifts count should be 2")
    }

    func testAddShift() throws {
        let newShift = Shift(date: Date().addingTimeInterval(172800), duration: 5400)
        shiftRepository.shifts.append(newShift)
        XCTAssertEqual(shiftRepository.shifts.count, 3, "Shifts count should be 3 after adding a new shift")
    }
}
