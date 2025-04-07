//
//  Settings.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 02/04/25.
//

// Settings.swift
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
    
    /// Returns the color associated with the theme.
    /// - Parameter scheme: The current color scheme
    /// - Returns: The color for the theme
    func color(_ scheme: ColorScheme) -> Color {
        switch self {
        case .systemDefault:
            return scheme == .dark ? Color.moonColor : Color.sunColor
        case .light:
            return Color.sunColor
        case .dark:
            return Color.moonColor
        }
    }

    /// Returns the color scheme associated with the theme
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
