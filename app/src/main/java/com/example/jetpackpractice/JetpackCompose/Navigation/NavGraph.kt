package com.example.jetpackpractice.JetpackCompose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MyNavRoutes.LoginScreen
    ) {
        //Destinations
        composable<MyNavRoutes.LoginScreen> {
            LoginScreenUI(navController)
        }

        composable<MyNavRoutes.HomeScreen> {
            HomeScreenUI(navController)
        }

        //backStackEntry is a lambda function,
        // having data and argument and which are pass during navigation
        composable<MyNavRoutes.WelcomeScreenData> { backStackEntry ->
            val data = backStackEntry.toRoute<MyNavRoutes.WelcomeScreenData>()
            WelcomeScreenUI(data.userName, navController)
        }
    }
}