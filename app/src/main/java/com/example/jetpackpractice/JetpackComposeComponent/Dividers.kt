package com.example.jetpackpractice.JetpackComposeComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HorizontalDividerExamples() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Profile Section",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        //Horizontal Divider Example
        HorizontalDivider(
            modifier = Modifier.width(300.dp).padding(16.dp),
            thickness = 2.dp,
            color = Color.Black
        )

        Text(
            text = "Personal Detail",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VerticalDividerExample() {
    Row(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Profile Section",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        //Vertical Divider Example
        VerticalDivider(
            modifier = Modifier.height(200.dp).padding(16.dp),
            thickness = 2.dp,
            color = Color.Black
        )

        Text(
            text = "Personal Detail",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}