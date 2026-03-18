package com.example.jetpackpractice.JetpackCompose.Navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class MyNavRoutes {
    @Serializable
    object LoginScreen : MyNavRoutes()

    @Serializable
    object HomeScreen : MyNavRoutes()

    @Serializable
    data class WelcomeScreenData(var userName: String) : MyNavRoutes()
}