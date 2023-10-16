package com.nickdferrara.ui_android_fitnessapp.data.models

import java.time.LocalDateTime

data class Workout(
    val description: String,
    val capacity: Int,
    val startDateTime: LocalDateTime,
    val coach: String,
    val duration: Int,
    val image: Int
)
