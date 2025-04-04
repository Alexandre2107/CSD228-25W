//
//  EmployeeView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 02/04/25.
//

import SwiftUI

/// A view that displays a list of employees
struct EmployeeView: View {
    var employees: [Employee]

    var body: some View {
        VStack {
            Text("Employees")
                .font(.title2.bold())
                .padding(.top, 25)

            // Loop through all employees and display their information
            ForEach(employees) { employee in
                Text("\(employee.name) - \(employee.position)")
                    .padding(.vertical, 5)
            }
        }
        .padding()
    }
}
