//
//  SettingsViewTests.swift
//  lab5UITests
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import XCTest
import SwiftUI
@testable import lab5

class SettingsViewTests: XCTestCase {
    @State private var userTheme: Theme = .systemDefault

    func testSettingsView() {
        let view = SettingsView(userTheme: $userTheme)
        XCTAssertNotNil(view)
    }
}
