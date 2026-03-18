package com.example.jetpackpractice.JetpackCompose.NavBar

import kotlinx.serialization.Serializable

@Serializable
sealed class NavBarRoutes {

    @Serializable
    object Home : NavBarRoutes()
    @Serializable
    object Notification : NavBarRoutes()

    @Serializable
    object Search : NavBarRoutes()

    @Serializable
    object Profile : NavBarRoutes()


}