package com.example.jetpackpractice.JetpackCompose.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Lazy column list example
@Composable
fun LazyColumnExample() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(20){ index ->
            Text(
                text = "Item $index",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            )
        }
    }
}

//Lazy Row List Example
@Composable
fun LazyRowExample() {
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(20){ index ->
            Text(
                text = "Item $index",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = Color.DarkGray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(16.dp)
            )
        }
    }
}


@Composable
fun NestedLazyList() {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        items(10) { rowIndex ->
            Text(
                text = "Row $rowIndex",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(15){ columnIndex ->
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .background(
                                color = Color.LightGray,
                                shape = RoundedCornerShape(16.dp)
                            ), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Item $columnIndex",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemsList() {
    Row (
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        //Simple Item
        LazyColumn() {
            item {
                Text(text = "Header")
            }
        }

        //Items with count
        LazyColumn() {
            items(10) { index ->
                Text(text = "List 1")
            }
        }

        //Items with argument
        var names = listOf("Alice","Bob","Charles","David","Eve")
        LazyColumn() {
            items(names) { name ->
                Text(text = name)
            }
        }

        //Items with name and index
        LazyColumn() {
            itemsIndexed(names) { index, name ->
                Text(text = "$index - $name")
            }
        }
    }
}
