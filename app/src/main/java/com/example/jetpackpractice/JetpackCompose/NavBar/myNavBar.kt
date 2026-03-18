package com.example.jetpackpractice.JetpackCompose.NavBar

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController

@Composable
fun MyNavBar(navController: NavHostController, key: String) {
    val navItems = listOf(
        MyNavItem("Home", Icons.Default.Home, NavBarRoutes.Home),
        MyNavItem("Notification", Icons.Default.Notifications, NavBarRoutes.Notification),
        MyNavItem("Search", Icons.Default.Search, NavBarRoutes.Search),
        MyNavItem("Profile", Icons.Default.Person, NavBarRoutes.Profile),
    )

    val selectedItems = navItems.indexOfFirst { it.title == key }.coerceAtLeast(0)
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val itemWidth = screenWidth / navItems.size
    val indicatorWidth = 28.dp

    val animateOffSet by animateDpAsState(
        targetValue = itemWidth * selectedItems + (itemWidth - indicatorWidth) / 2,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "topIndicator"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .offset(x = animateOffSet, y = 6.dp)
                .width(indicatorWidth)
                .height(4.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.Blue)
                .zIndex(1f)
        )

        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.White
        ){
            navItems.forEach { items ->
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
                            imageVector = items.icon,
                            contentDescription = items.title
                        )
                    },
                    label = {Text(items.title)},
                    colors = NavigationBarItemDefaults.colors(
                        selectedTextColor = Color.Blue,
                        selectedIconColor = Color.Blue,
                        unselectedIconColor = Color.DarkGray,
                        unselectedTextColor = Color.DarkGray,
                        indicatorColor = Color.Unspecified
                    )
                )
            }
        }
    }
}

data class MyNavItem(
    var title : String,
    var icon : ImageVector,
    var routes: NavBarRoutes
)