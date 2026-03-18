package com.example.jetpackpractice.JetpackCompose.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StateManagementExample() {
    var score by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Score : $score", fontSize = 30.sp)


        Row() {
            Button(
                onClick = {
                    score++
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    score--
                },
                modifier = Modifier.weight(1f),
                enabled = score > 0
            ) {
                Text(text = "Decrease")
            }
        }
    }
}

//RememberSavable used to store the value when the state configuration is also changed(like theme change )
@Composable
fun RememberSavableExample() {

    var score by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Score : $score", fontSize = 30.sp)

        Row() {
            Button(
                onClick = {
                    score++
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    score--
                },
                modifier = Modifier.weight(1f),
                enabled = score > 0
            ) {
                Text(text = "Decrease")
            }
        }
    }
}

//State Hoisting use to reuse the variable in child function
@Composable
fun StateHoistingParent() {
    var score by remember { mutableStateOf(0) }
    CounterChild(
        score = score,
        increment = {score++},
        decrement = {score--}
    )
}

@Composable
fun CounterChild(score: Int, increment: () -> Int, decrement: () -> Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Score : $score", fontSize = 30.sp)

        Row() {
            Button(
                onClick = {
                    increment()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Increase")
            }
            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    decrement()
                },
                modifier = Modifier.weight(1f),
                enabled = score > 0
            ) {
                Text(text = "Decrease")
            }
        }
    }
}