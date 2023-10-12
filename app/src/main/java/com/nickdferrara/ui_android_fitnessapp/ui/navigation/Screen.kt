package com.nickdferrara.ui_android_fitnessapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, var title: String) {
    object Home: Screen("home_screen", Icons.Filled.Home, "Home")
    object Workout: Screen("workout_screen", Icons.Filled.DateRange, "Workout")
    object Store: Screen("store_screen", Icons.Filled.ShoppingCart, "Store")
}
