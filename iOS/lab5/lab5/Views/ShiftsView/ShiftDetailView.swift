//
//  ShiftDetailView.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 04/04/25.
//

import SwiftUI

/// Displays detailed information about a shift
struct ShiftDetailView: View {
    var shift: Shift

    var body: some View {
        VStack {
            Text("Date: \(shift.date)")
            Text("Duration: \(String(format: "%.1f", shift.duration / 3600)) hours")
        }
        .navigationTitle("Shift Details")
    }
}
