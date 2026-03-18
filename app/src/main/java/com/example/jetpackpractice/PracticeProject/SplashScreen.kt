package com.example.jetpackpractice.PracticeProject

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackpractice.R

@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember { Animatable(0f) }
    LaunchedEffect(true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1500)
        )

        navController.navigate("home"){
            popUpTo("splash") {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.splash_screen_logo),
                contentDescription = "Splash Screen Logo",
                modifier = Modifier
                    .size(100.dp)
                    .scale(scale.value)
            )

            Text(
                text = "Weather App",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.scale(scale.value)
            )
        }
    }
}