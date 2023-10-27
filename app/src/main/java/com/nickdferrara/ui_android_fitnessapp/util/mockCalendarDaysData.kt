package com.nickdferrara.ui_android_fitnessapp.util

import java.time.LocalDate

fun findLastSeveDays(): List<LocalDate> {
    return (0..6).map {
        LocalDate.now().plusDays(it.toLong())
    }
}


