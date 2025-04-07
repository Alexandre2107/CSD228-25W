//
//  ThemeSwitcherViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
@testable import lab5
import SwiftUI

class ThemeSwitcherViewTests: XCTestCase {
    
    var settings: Settings!
    @Environment(\.colorScheme) private var scheme

    override func setUp() {
        super.setUp()
        settings = Settings()
    }

    override func tearDown() {
        settings = nil
        super.tearDown()
    }

    func testThemeSwitcherView() {
        let view = ThemeSwitcherView(scheme: scheme)
        XCTAssertNotNil(view)
    }

    func testThemeChange() {
        settings.theme = .dark
        XCTAssertEqual(settings.theme, .dark)
    }
}
