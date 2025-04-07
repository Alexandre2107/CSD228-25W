//
//  SettingsView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import SwiftUI

/// Displays the settings view where the user can change the theme
struct SettingsView: View {
    @Binding var userTheme: Theme
    @Environment(\.colorScheme) private var scheme

    var body: some View {
        VStack {
            ThemeSwitcherView(scheme: scheme)
                .presentationDetents([.height(410)])
                .presentationBackground(.clear)
            
                
        }
        .navigationTitle("Settings")
    }
}
