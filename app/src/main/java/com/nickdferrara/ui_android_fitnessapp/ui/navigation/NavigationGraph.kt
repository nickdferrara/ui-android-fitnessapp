package com.nickdferrara.ui_android_fitnessapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import com.nickdferrara.ui_android_fitnessapp.ui.screen.home.HomeScreen
import com.nickdferrara.ui_android_fitnessapp.ui.screen.store.StoreScreen
import com.nickdferrara.ui_android_fitnessapp.ui.screen.workout.WorkoutScreen

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController = navController) }
        composable(Screen.Workout.route) { WorkoutScreen(navController = navController) }
        composable(Screen.Store.route) { StoreScreen(navController = navController) }
        composable(Screen.Settings.route) { StoreScreen(navController = navController) }
    }
}