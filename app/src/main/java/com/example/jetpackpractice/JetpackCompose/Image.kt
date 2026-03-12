package com.example.jetpackpractice.JetpackCompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackpractice.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImageExample() {
    Image(
        painter = painterResource(R.drawable.sample_image1),
        contentDescription = "SampleImage",
        modifier = Modifier
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .size(300.dp),
        contentScale = ContentScale.FillBounds,
        alignment = Alignment.Center
    )
}