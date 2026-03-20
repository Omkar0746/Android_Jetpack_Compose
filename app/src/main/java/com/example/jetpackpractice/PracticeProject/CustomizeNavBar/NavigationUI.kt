package com.example.jetpackpractice.PracticeProject.CustomizeNavBar

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackpractice.PracticeProject.CustomizeNavBar.Screens.CartScreenPage
import com.example.jetpackpractice.PracticeProject.CustomizeNavBar.Screens.HomeScreenPage
import com.example.jetpackpractice.PracticeProject.CustomizeNavBar.Screens.MenuScreenPage
import com.example.jetpackpractice.PracticeProject.CustomizeNavBar.Screens.ProfileScreenPage

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UINavigation() {
    val navController = rememberNavController()
    var openExitDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val activity = context as? Activity

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    BackHandler(enabled = currentRoute == "Home") {
        openExitDialog = true
    }

    Scaffold(
        bottomBar = { CustomBottomBar(navController = navController) },
        modifier = Modifier.navigationBarsPadding()
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("Home") {
                HomeScreenPage()
            }
            composable("Cart") {
                CartScreenPage()
            }
            composable("Profile") {
                ProfileScreenPage()
            }
            composable("Menu") {
                MenuScreenPage()
            }
        }

        if (openExitDialog) {
            AlertDialog(
                onDismissRequest = { openExitDialog = false },
                title = {
                    Text(
                        text = "Exit App",
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {
                    Text(
                        text = "Are you sure you want to exit?",
                        fontWeight = FontWeight.SemiBold
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openExitDialog = false
                            activity?.finish()
                        }
                    ) {
                        Text(
                            text = "Yes",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openExitDialog = false
                        }
                    ) {
                        Text(
                            text = "No",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }
                },
                containerColor = Color.White
            )
        }
    }
}