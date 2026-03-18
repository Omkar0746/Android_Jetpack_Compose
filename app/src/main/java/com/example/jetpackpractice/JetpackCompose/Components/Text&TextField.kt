package com.example.jetpackpractice.JetpackCompose.Components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextExample() {
    Text(
        text = "JetPack Compose",
        color = Color.Blue,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextFieldExample() {
    var name by remember { mutableStateOf("") }
    TextField(
        value = name,
        onValueChange = { name = it },
        placeholder = { Text(text = "Enter your name") },
        leadingIcon = { Text(text = "#") },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color.Red,
            unfocusedContainerColor = Color.Blue,
            focusedContainerColor = Color.Gray
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OutlineTextFieldExample() {
    var name by remember { mutableStateOf("") }
    OutlinedTextField(
        value = name,
        onValueChange = {name = it},
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Magenta
        ),
        label = {Text(
            text = "Enter your name"
        )},
        leadingIcon = {Text(
            text = "@"
        )},
        trailingIcon = {Text(
            text = "+"
        )}
    )
}