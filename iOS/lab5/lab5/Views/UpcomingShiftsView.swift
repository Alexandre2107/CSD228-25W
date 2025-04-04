//
//  UpcomingShiftsView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 02/04/25.
//

import SwiftUI

/// A view that displays a list of upcoming shifts
struct UpcomingShiftsView: View {
    var shifts: [Shift]

    var body: some View {
        VStack {
            Text("Upcoming Shifts")
                .font(.title2.bold())
                .padding(.top, 25)

            // Loop through all upcoming shifts and display their information
            ForEach(shifts) { shift in
                Text("Date: \(shift.date), Duration: \(String(format: "%.1f", shift.duration / 3600)) hours")
                    .padding(.vertical, 5)
            }
        }
        .padding()
    }
}
