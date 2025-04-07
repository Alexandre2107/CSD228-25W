//
//  ThemeSwitcherView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 25/03/25.
//

import SwiftUI

/// A view that allows the user to switch between different themes
struct ThemeSwitcherView: View {
    /// The current color scheme (light or dark) of the device
    var scheme: ColorScheme
    /// The user's selected theme, stored in AppStorage to persist across app launches
    @AppStorage("userTheme") private var userTheme: Theme = .systemDefault
    /// Namespace for matched geometry effects
    @Namespace private var animation
    /// State variable to control the offset of the circle mask
    @State private var circleOffset: CGSize

    /// Initializes the view with the given color scheme
    /// - Parameter scheme: The current color scheme of the device
    init(scheme: ColorScheme) {
        self.scheme = scheme
        let isDark = scheme == .dark
        // Set the initial offset based on the color scheme
        self._circleOffset = .init(initialValue: CGSize(width: isDark ? 30 : 150, height: isDark ? -25 : 150))
    }

    var body: some View {
        VStack(spacing: 15) {
            // Circle with a gradient fill that changes based on the selected theme
            Circle()
                .fill(userTheme.color(scheme).gradient)
                .frame(width: 150, height: 150)
                .mask {
                    Rectangle()
                        .overlay {
                            Circle()
                                .offset(circleOffset)
                                .blendMode(.destinationOut)
                        }
                }

            // Title text for the theme selection section
            Text("Choose a theme")
                .font(.title2.bold())
                .padding(.top, 25)

            // View containing the theme selection buttons
            themeSelectionView
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .frame(height: 410)
        .background(Color.backgroundColor)
        .clipShape(RoundedRectangle(cornerRadius: 30))
        .padding(.horizontal, 15)
        .environment(\.colorScheme, scheme)
        .onChange(of: scheme, initial: false) { _, newValue in
            let isDark = newValue == .dark
            withAnimation(.bouncy) {
                circleOffset = CGSize(width: isDark ? 30 : 150, height: isDark ? -25 : 150)
            }
        }
    }

    /// A view that displays the theme selection buttons
    private var themeSelectionView: some View {
        HStack(spacing: 0) {
            // Loop through all available themes and create a button for each
            ForEach(Theme.allCases, id: \.rawValue) { theme in
                themeButton(for: theme)
            }
        }
        .padding(3)
        .background(Color.primary.opacity(0.06), in: Capsule())
        .padding(.top, 20)
    }

    /// Creates a button for the given theme
    /// - Parameter theme: The theme for which to create the button
    /// - Returns: A view representing the theme button
    private func themeButton(for theme: Theme) -> some View {
        Text(theme.rawValue)
            .padding(.vertical, 5)
            .frame(width: 100)
            .background {
                ZStack {
                    if userTheme == theme {
                        Capsule()
                            .fill(Color.backgroundColor)
                            .matchedGeometryEffect(id: "ACTIVATETAB", in: animation)
                    }
                }
                .animation(.snappy, value: userTheme)
            }
            .contentShape(Rectangle())
            .onTapGesture {
                userTheme = theme
            }
    }
}

//import SwiftUI
//
///// A view that allows the user to switch between different themes
//struct ThemeSwitcherView: View {
//    @ObservedObject var settings: Settings
//
//    var body: some View {
//        VStack {
//            Text("Choose a theme")
//                .font(.title2.bold())
//                .padding(.top, 25)
//
//            HStack(spacing: 0) {
//                // Loop through all available themes
//                ForEach(Theme.allCases, id: \.rawValue) { theme in
//                    Text(theme.rawValue)
//                        .padding(.vertical, 5)
//                        .frame(width: 100)
//                        .background(settings.theme == theme ? Color.gray : Color.clear)
//                        .onTapGesture {
//                            // Update the theme when tapped
//                            settings.theme = theme
//                        }
//                        .accessibility(identifier: "Theme_\(theme.rawValue)")
//                }
//            }
//            .padding(3)
//            .background(Color.primary.opacity(0.06))
//            .padding(.top, 20)
//        }
//        .padding()
//    }
//}



