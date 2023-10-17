package com.nickdferrara.ui_android_fitnessapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, var title: String) {
    object Home: Screen(
        route = "home_screen",
        icon = Icons.Filled.Home,
        title ="Home"
    )
    object Workout: Screen(
        route = "workout_screen",
        icon = Icons.Filled.DateRange,
        title = "Workouts"
    )

    object Store: Screen(
        route = "store_screen",
        icon = Icons.Filled.ShoppingCart,
        title = "Store"
    )

    object Settings: Screen(
        route = "settings_screen",
        icon = Icons.Filled.Settings,
        title = "Settings"
    )
}
