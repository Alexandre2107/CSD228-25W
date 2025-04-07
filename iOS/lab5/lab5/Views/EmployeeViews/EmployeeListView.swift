//
//  EmployeeListView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import SwiftUI

/// Displays a list of employees with navigation to their details
struct EmployeesListView: View {
    @StateObject private var employeeRepository = EmployeeRepository()

    var body: some View {
        List(employeeRepository.employees) { employee in
            NavigationLink(destination: EmployeeDetailView(employee: employee)) {
                Text("\(employee.name) - \(employee.position)")
            }
        }
        .navigationTitle("Employees")
    }
}
