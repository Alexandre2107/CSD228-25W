//
//  SettingsRepositoryTests.swift
//  lab5Tests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
@testable import lab5

class SettingsRepositoryTests: XCTestCase {
    var settings: Settings!

    override func setUp() {
        super.setUp()
        settings = Settings()
    }

    override func tearDown() {
        settings = nil
        super.tearDown()
    }

    func testInitialTheme() {
        XCTAssertEqual(settings.theme, .systemDefault, "Initial theme should be systemDefault")
    }

    func testThemeChangeToLight() {
        settings.theme = .light
        XCTAssertEqual(settings.theme, .light, "Theme should be light after setting it to light")
    }

    func testThemeChangeToDark() {
        settings.theme = .dark
        XCTAssertEqual(settings.theme, .dark, "Theme should be dark after setting it to dark")
    }
}
