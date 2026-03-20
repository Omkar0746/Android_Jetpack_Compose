package com.example.jetpackpractice.PracticeProject.CustomizeNavBar.Screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.filled.PlaylistAddCheckCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreenPage() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {HomeScreenTabs(navController)}
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "Songs",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("Songs") {
                SongScreenPage()
            }
            composable("Album") {
                AlbumScreenPage()
            }
            composable("Playlist") {
                PlaylistScreenPage()
            }
        }
    }
}

data class TabItems(
    val icon: ImageVector,
    val routes : String
)

val tabItems = listOf(
    TabItems(Icons.Default.MusicNote, "Songs"),
    TabItems(Icons.Default.Album, "Album"),
    TabItems(Icons.Default.PlaylistAddCheckCircle, "Playlist")
)

@Composable
fun HomeScreenTabs(navController : NavHostController) {
    val tabBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = tabBackStackEntry?.destination?.route
    val selectedIndex = tabItems
        .indexOfFirst { item -> item.routes == currentRoute }
        .coerceAtLeast(0)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(Color(0xFF0FCD74))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabItems.forEachIndexed { index, item ->

                val isSelected = selectedIndex == index

                val scale by animateFloatAsState(
                    targetValue = if (isSelected) 1.25f else 1f,
                    animationSpec = tween(400),
                    label = "icon_scale"
                )

                IconButton(
                    onClick = {
                        navController.navigate(item.routes){
                            popUpTo (navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.routes,
                            tint = Color.White,
                            modifier = Modifier.scale(scale)
                        )
                    }
                }
            }
        }
    }
}