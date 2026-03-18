package com.example.jetpackpractice.JetpackCompose.NavBar

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavBarNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavBarRoutes.Home
    ){
        composable<NavBarRoutes.Home>{
            NavBarHomeScreen(navController)
        }

        composable<NavBarRoutes.Notification>{
            NavBarNotificationScreen(navController)
        }

        composable<NavBarRoutes.Search>{
            NavBarSearchScreen(navController)
        }

        composable<NavBarRoutes.Profile>{
            NavBarProfileScreen(navController)
        }
    }
}