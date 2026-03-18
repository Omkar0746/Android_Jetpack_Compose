package com.example.jetpackpractice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.jetpackpractice.JetpackCompose.NavBar.NavBarNavigation
import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme

class MainActivity : ComponentActivity() {
    private var isLoading = true
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            isLoading
        }

        splashScreen.setOnExitAnimationListener { splashView ->
            splashView.view.animate()
                .alpha(0f)
                .setDuration(500)
                .withEndAction {
                    splashView.remove()
                }
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Handler(Looper.getMainLooper()).postDelayed({
            isLoading = false
        }, 2000)

        setContent {
            JetpackPracticeTheme {
                NavBarNavigation()
            }
        }
    }
}