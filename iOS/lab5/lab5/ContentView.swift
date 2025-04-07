//
//  ContentView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 25/03/25.
//

import SwiftUI

/// The main content view that displays the main menu and other views
struct ContentView: View {
    @State private var changeTheme = false
    @Environment(\.colorScheme) private var scheme
    @AppStorage("userTheme") private var userTheme: Theme = .systemDefault

    var body: some View {
        NavigationView {
            List {
                Section("Appearance") {
                    Button("Change Theme") {
                        changeTheme.toggle()
                    }
                }
                NavigationLink("Settings", destination: SettingsView(userTheme: $userTheme))
                NavigationLink("Shifts", destination: ShiftsListView())
                NavigationLink("Employees", destination: EmployeesListView())
            }
            .navigationTitle("Main Menu")
        }
        .preferredColorScheme(userTheme.colorScheme)
        .sheet(isPresented: $changeTheme, content: {
            ThemeSwitcherView(scheme: scheme)
                .presentationDetents([.height(410)])
                .presentationBackground(.clear)
        })
    }
}
///// The main content view that displays all other views
//struct ContentView: View {
//    @StateObject private var settings = Settings()
//    @StateObject private var shiftRepository = ShiftRepository()
//    @StateObject private var employeeRepository = EmployeeRepository()
//
//    var body: some View {
//        VStack {
//            // View to switch between light and dark mode
//            ThemeSwitcherView(settings: settings)
//                .accessibility(identifier: "ThemeSwitcherView")
//            // View to display employee information
//            EmployeeView(employees: employeeRepository.employees)
//                .accessibility(identifier: "EmployeeView")
//            // View to display worked shifts
//            WorkedShiftsView(shifts: shiftRepository.shifts)
//                .accessibility(identifier: "WorkedShiftsView")
//            // View to display upcoming shifts
//            UpcomingShiftsView(shifts: shiftRepository.shifts)
//                .accessibility(identifier: "UpcomingShiftsView")
//        }
//        // Apply the selected color scheme
//        .preferredColorScheme(settings.theme.colorScheme)
//        .accessibility(identifier: "ContentView")
//    }
//}

#Preview {
    ContentView()
}
