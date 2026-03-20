package com.example.jetpackpractice.PracticeProject.CustomizeNavBar.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SongScreenPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Song Screen",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun AlbumScreenPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Album Screen",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun PlaylistScreenPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Playlist Screen",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}