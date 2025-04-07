//
//  ShiftListViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
import SwiftUI
@testable import lab5

class ShiftsListViewTests: XCTestCase {
    var shiftRepository: ShiftRepository!

    override func setUp() {
        super.setUp()
        shiftRepository = ShiftRepository()
    }

    override func tearDown() {
        shiftRepository = nil
        super.tearDown()
    }

    func testShiftsListView() {
        let view = ShiftsListView()
        XCTAssertNotNil(view)
    }
}
