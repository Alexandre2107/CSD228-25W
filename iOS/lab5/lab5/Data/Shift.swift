//
//  Shift.swift
//  lab5
//
//  Created by Alexandre Rodrigues on 02/04/25.
//

import Foundation
import Combine

/// Class representing a work shift
class Shift: Identifiable, ObservableObject {
    /// ID for the shift
    let id = UUID()
    /// Date of the shift
    @Published var date: Date
    /// Duration of the shift in seconds
    @Published var duration: TimeInterval

    /// Initializes a new shift with the given date and duration
    ///   - Parameters:
    ///   - date: The date of the shift
    ///   - duration: The duration of the shift in seconds
    init(date: Date, duration: TimeInterval) {
        self.date = date
        self.duration = duration
    }
}

/// Class that manages a collection of shifts
class ShiftRepository: ObservableObject {
    /// An array of shifts
    @Published var shifts: [Shift] = []

    /// Initializes the repository with some test data
    init() {
        shifts = [
            Shift(date: Date(), duration: 3600),
            Shift(date: Date().addingTimeInterval(86400), duration: 7200)
        ]
    }
}
