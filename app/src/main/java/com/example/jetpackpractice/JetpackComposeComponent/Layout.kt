package com.example.jetpackpractice.JetpackComposeComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun RowExample() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = "Apple", fontSize = 20.sp)
        Text(text = "Orange", fontSize = 20.sp)
        Text(text = "Banana", fontSize = 20.sp)
    }
}

@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Apple", fontSize = 20.sp)
        Text(text = "Orange", fontSize = 20.sp)
        Text(text = "Banana", fontSize = 20.sp)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BoxExample() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Apple",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.TopStart)
            )
        Text(
            text = "Orange",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        Text(
            text = "Banana",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Center))
    }

}