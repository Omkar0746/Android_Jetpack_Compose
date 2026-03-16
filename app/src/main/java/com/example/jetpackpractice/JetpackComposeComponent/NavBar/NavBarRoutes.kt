package com.example.jetpackpractice.JetpackComposeComponent.NavBar

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