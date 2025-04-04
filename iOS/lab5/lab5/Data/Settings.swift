//
//  Settings.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 02/04/25.
//

import Foundation
import Combine
import SwiftUI

/// Class that manages the application's theme settings
class Settings: ObservableObject {
    /// Current theme of the application
    @Published var theme: Theme = .systemDefault
}

/// Enum representing the available themes for the application
enum Theme: String, CaseIterable {
    case systemDefault = "Default"
    case light = "Light"
    case dark = "Dark"

    /// Property that eturns the corresponding `ColorScheme` for each theme.
    var colorScheme: ColorScheme? {
        switch self {
        case .systemDefault:
            return nil
        case .light:
            return .light
        case .dark:
            return .dark
        }
    }
}
