package com.nickdferrara.ui_android_fitnessapp.util

import com.nickdferrara.ui_android_fitnessapp.R
import com.nickdferrara.ui_android_fitnessapp.data.models.Workout
import java.time.LocalDateTime

fun findMockUpcomingWorkouts(): List<Workout> {
    return listOf(
        Workout(
            description = "Spin + Recovery",
            capacity = 20,
            startDateTime = LocalDateTime.now(),
            coach = "Amanda Ferrara",
            duration = 45,
            image = R.drawable.spin_class
        ),
        Workout(
            description = "Yoga + Sculpt",
            capacity = 22,
            startDateTime = LocalDateTime.now(),
            coach = "Amanda Ferrara",
            duration = 30,
            image = R.drawable.yoga_class
        ),
        Workout(
            description = "Cycle + Core",
            capacity = 22,
            startDateTime = LocalDateTime.now(),
            coach = "Lindsay Sargood",
            duration = 45,
            image = R.drawable.spin_class
        )
    )
}