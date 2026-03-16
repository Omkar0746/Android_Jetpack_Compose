package com.example.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.jetpackpractice.JetpackComposeComponent.LazyColumnExample
import com.example.jetpackpractice.JetpackComposeComponent.LazyRowExample
import com.example.jetpackpractice.JetpackComposeComponent.Navigation.NavGraph
import com.example.jetpackpractice.JetpackComposeComponent.NestedLazyList
import com.example.jetpackpractice.JetpackComposeComponent.Scaffold.ScaffoldExample
import com.example.jetpackpractice.JetpackComposeComponent.SnackBarExample
import com.example.jetpackpractice.JetpackComposeComponent.ToastExample
import com.example.jetpackpractice.JetpackComposeComponent.navigation_bar.NavBarNavigation
import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPracticeTheme {
                NavBarNavigation()
            }
        }
    }
}