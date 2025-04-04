//
//  ThemeSwitcherView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 25/03/25.
//

//import SwiftUI

//struct ThemeSwitcherView: View {
//    var scheme: ColorScheme
//    @AppStorage("userTheme") private var userTheme: lab5.Theme = .systemDefault
//    @Namespace private var animation
//    @State private var circleOffset: CGSize
//
//    init(scheme: ColorScheme) {
//        self.scheme = scheme
//        let isDark = scheme == .dark
//        self._circleOffset = .init(initialValue: CGSize(width: isDark ? 30 : 150, height: isDark ? -25 : 150))
//    }
//
//    var body: some View {
//        VStack(spacing: 15) {
////            Circle()
////                .fill(userTheme.color(scheme).gradient)
////                .frame(width: 150, height: 150)
////                .mask {
////                    Rectangle()
////                        .overlay {
////                            Circle()
////                                .offset(circleOffset)
////                                .blendMode(.destinationOut)
////                        }
////                }
//
//            Text("Choose a theme")
//                .font(.title2.bold())
//                .padding(.top, 25)
//
//            HStack(spacing: 0) {
//                ForEach(lab5.Theme.allCases, id: \.rawValue) { theme in
//                    Text(theme.rawValue)
//                        .padding(.vertical, 5)
//                        .frame(width: 100)
//                        .background {
//                            ZStack {
//                                if userTheme == theme {
//                                    Capsule()
//                                        .fill(.themeBG)
//                                        .matchedGeometryEffect(id: "ACTIVATETAB", in: animation)
//                                }
//                            }
//                            .animation(.snappy, value: userTheme)
//                        }
//                        .contentShape(.rect)
//                        .onTapGesture {
//                            userTheme = theme
//                        }
//                }
//            }
//            .padding(3)
//            .background(.primary.opacity(0.06), in: .capsule)
//            .padding(.top, 20)
//        }
//        .frame(maxWidth: .infinity, maxHeight: .infinity)
//        .frame(height: 150)
//        .background(.themeBG)
//        .clipShape(.rect(cornerRadius: 30))
//        .padding(.horizontal, 15)
//        .environment(\.colorScheme, scheme)
//        .onChange(of: scheme, initial: false) { _, newValue in
////            let isDark = newValue == .dark
////            withAnimation(.bouncy) {
////                circleOffset = CGSize(width: isDark ? 30 : 150, height: isDark ? -25 : 150)
////            }
//        }
//    }
//}
//
//#Preview {
//    ContentView()
//}
//
//enum Theme: String, CaseIterable {
//    case systemDefault = "Default"
//    case light = "Light"
//    case dark = "Dark"
//
//    func color(_ scheme: ColorScheme) -> Color {
//        switch self {
//        case .systemDefault:
//            return scheme == .dark ? .moon : .sun
//        case .light:
//            return .sun
//        case .dark:
//            return .moon
//        }
//    }
//
//    var colorScheme: ColorScheme? {
//        switch self {
//        case .systemDefault:
//            return nil
//        case .light:
//            return .light
//        case .dark:
//            return .dark
//        }
//    }
//}

import SwiftUI

/// A view that allows the user to switch between different themes
struct ThemeSwitcherView: View {
    @ObservedObject var settings: Settings

    var body: some View {
        VStack {
            Text("Choose a theme")
                .font(.title2.bold())
                .padding(.top, 25)

            HStack(spacing: 0) {
                // Loop through all available themes
                ForEach(Theme.allCases, id: \.rawValue) { theme in
                    Text(theme.rawValue)
                        .padding(.vertical, 5)
                        .frame(width: 100)
                        .background(settings.theme == theme ? Color.gray : Color.clear)
                        .onTapGesture {
                            // Update the theme when tapped
                            settings.theme = theme
                        }
                        .accessibility(identifier: "Theme_\(theme.rawValue)")
                }
            }
            .padding(3)
            .background(Color.primary.opacity(0.06))
            .padding(.top, 20)
        }
        .padding()
    }
}



