//
//  EmployeeDetailView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import SwiftUI

/// Displays detailed information about an employee
struct EmployeeDetailView: View {
    var employee: Employee

    var body: some View {
        VStack {
            Spacer()
            VStack {
                Text("Name: \(employee.name)")
                Text("Position: \(employee.position)")
                if let shift = employee.shift {
                    Text("Shift Date: \(shift.date)")
                    Text("Shift Duration: \(String(format: "%.1f", shift.duration / 3600)) hours")
                } else {
                    Text("No shift assigned")
                }
            }
            .multilineTextAlignment(.center)
            Spacer()
        }
        .navigationTitle("Employee Details")
    }
}
