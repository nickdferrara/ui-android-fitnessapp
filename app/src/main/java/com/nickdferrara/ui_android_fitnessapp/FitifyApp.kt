package com.nickdferrara.ui_android_fitnessapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.nickdferrara.ui_android_fitnessapp.ui.navigation.BottomNavigationBar
import com.nickdferrara.ui_android_fitnessapp.ui.navigation.NavigationGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitifyApp(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavigationGraph(
            navController = navController,
            innerPadding = innerPadding
        )
    }
}