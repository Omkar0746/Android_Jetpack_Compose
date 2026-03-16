package com.example.jetpackpractice.JetpackComposeComponent.NavBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

@Composable
fun MyNavBar(navController: NavHostController, key: String) {
    val navItems = listOf(
        MyNavItem("Home", Icons.Default.Home, NavBarRoutes.Home),
        MyNavItem("Notification", Icons.Default.Notifications, NavBarRoutes.Notification),
        MyNavItem("Search", Icons.Default.Search, NavBarRoutes.Search),
        MyNavItem("Profile", Icons.Default.Person, NavBarRoutes.Profile),
    )

    NavigationBar{
        navItems.forEach { items ->
            //Static way to implement navigation bar item for each item without using for each loop
            NavigationBarItem(
                selected = items.title == key,
                onClick = {
                    navController.navigate(items.routes){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = items.image,
                        contentDescription = items.title
                    )
                },
                label = {Text(items.title)},
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = Color.Blue,
                    selectedIconColor = Color.Blue,
                    indicatorColor = Color.Blue.copy(alpha = 0.1f)
                )
            )
        }
    }
}

data class MyNavItem(
    var title : String,
    var image : ImageVector,
    var routes: NavBarRoutes
)