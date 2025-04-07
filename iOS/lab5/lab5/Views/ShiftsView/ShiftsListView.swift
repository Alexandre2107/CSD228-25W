//
//  ShiftsListView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import SwiftUI

/// Displays a list of shifts with navigation to their details
struct ShiftsListView: View {
    @StateObject private var shiftRepository = ShiftRepository()

    var body: some View {
        List(shiftRepository.shifts) { shift in
            NavigationLink(destination: ShiftDetailView(shift: shift)) {
                Text("Date: \(shift.date), Duration: \(String(format: "%.1f", shift.duration / 3600)) hours")
            }
        }
        .navigationTitle("Shifts")
    }
}
