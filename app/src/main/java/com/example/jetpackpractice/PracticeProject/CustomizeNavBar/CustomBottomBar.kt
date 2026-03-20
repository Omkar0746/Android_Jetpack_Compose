package com.example.jetpackpractice.PracticeProject.CustomizeNavBar

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


data class NavItem(
    val icon: ImageVector,
    val routes : String
)

private val navItems = listOf(
    NavItem(Icons.Default.Home, "Home"),
    NavItem(Icons.Default.ShoppingCart, "Cart"),
    NavItem(Icons.Default.Person, "Profile"),
    NavItem(Icons.Default.Menu, "Menu")
)

@Composable
fun CustomBottomBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val selectedIndex = navItems.indexOfFirst { item -> item.routes == currentRoute }.coerceAtLeast(0)

    val animatedIndex by animateFloatAsState(
        targetValue = selectedIndex.toFloat(),
        animationSpec = tween(450, easing = FastOutSlowInEasing),
        label = "nav_animation"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
    ) {
        
        Canvas(modifier = Modifier.fillMaxSize()) {

            val width = size.width
            val height = size.height

            val itemWidth = width / navItems.size
            val centerX = itemWidth * animatedIndex + itemWidth / 2

            val bumpWidth = 180f
            val bumpHeight = 35f
            val bumpYOffset = 8f

            val path = Path().apply {
                moveTo(0f, 0f)

                lineTo(centerX - bumpWidth / 2, 0f)

                cubicTo(
                    centerX - bumpWidth / 3, 0f,
                    centerX - bumpWidth / 6, -bumpHeight + bumpYOffset,
                    centerX, -bumpHeight + bumpYOffset
                )

                cubicTo(
                    centerX + bumpWidth / 6, -bumpHeight + bumpYOffset,
                    centerX + bumpWidth / 3, 0f,
                    centerX + bumpWidth / 2, 0f
                )

                lineTo(width, 0f)
                lineTo(width, height)
                lineTo(0f, height)

                close()
            }

            drawPath(path, color = Color(0xFF0FCD74))
        }

        Canvas(modifier = Modifier.fillMaxSize()) {

            val width = size.width
            val itemWidth = width / navItems.size
            val circleX = itemWidth * animatedIndex + itemWidth / 2

            val centerY = size.height / 2 - 6f

            drawCircle(
                color = Color.White.copy(alpha = 0.25f),
                radius = 62f,
                center = Offset(circleX, centerY)
            )
        }

        Canvas(modifier = Modifier.fillMaxSize()) {

            val width = size.width
            val itemWidth = width / navItems.size
            val circleX = itemWidth * animatedIndex + itemWidth / 2

            val centerY = size.height / 2 - 6f

            drawCircle(
                color = Color.White.copy(alpha = 0.45f),
                radius = 44f,
                center = Offset(circleX, centerY)
            )
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            navItems.forEachIndexed { index, item ->

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