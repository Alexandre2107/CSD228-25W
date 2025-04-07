//
//  ShiftDetailViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
import SwiftUI
@testable import lab5

class ShiftDetailViewTests: XCTestCase {
    var shift: Shift!

    override func setUp() {
        super.setUp()
        shift = Shift(date: Date(), duration: 3600)
    }

    override func tearDown() {
        shift = nil
        super.tearDown()
    }

    func testShiftDetailView() {
        let view = ShiftDetailView(shift: shift)
        XCTAssertNotNil(view)
    }
}
