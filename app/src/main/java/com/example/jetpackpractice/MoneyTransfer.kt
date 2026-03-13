package com.example.jetpackpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackpractice.JetpackCompose.ModifiersExample
import com.example.jetpackpractice.ui.theme.JetpackPracticeTheme

class MoneyTransfer : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackPracticeTheme {

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MoneyTransferPage() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF121a83))
                .fillMaxHeight(0.30f)
                .padding(vertical = 30.dp, horizontal = 20.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.hamburg_icon),
                contentDescription = "Hamburg Icon",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Money Care",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 130.dp, 10.dp, 30.dp),
            colors = CardDefaults.cardColors(
                Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Main Balance", fontWeight = FontWeight.Bold, fontSize = 16.sp
                        )
                        Text(
                            text = "₹ 7.46", fontWeight = FontWeight.Bold, fontSize = 18.sp
                        )
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFF121a83)
                            ),
                            contentPadding = PaddingValues(15.dp, 10.dp)
                        ) { Text(text = "Add Fund") }
                    }
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "AEPS", fontWeight = FontWeight.Bold, fontSize = 16.sp
                        )
                        Text(
                            text = "₹ 0.00", fontWeight = FontWeight.Bold, fontSize = 18.sp
                        )
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                Color(0xFF121a83)
                            ),
                            contentPadding = PaddingValues(15.dp, 10.dp)
                        ) { Text(text = "Settle Fund") }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                FeaturesGrid()
            }
        }
    }
}


@Composable
fun FeaturesGrid() {
    val featureList = arrayListOf(
        Features(R.drawable.currency, "Money Transfer"),
        Features(R.drawable.currency2, "Money Transfer 3"),
        Features(R.drawable.currency, "UPI"),
        Features(R.drawable.currency2, "AEPS"),
        Features(R.drawable.currency, "CMS"),
        Features(R.drawable.currency2, "AEPS2"),
        Features(R.drawable.currency, "PPI"),
        Features(R.drawable.currency2, "Aadhaar Pay"),
        Features(R.drawable.currency, "Online Topup"),
        Features(R.drawable.currency2, "Prepaid"),
        Features(R.drawable.currency, "DTH"),
        Features(R.drawable.currency2, "Bill Payment"),
        Features(R.drawable.currency, "Wallet"),
        Features(R.drawable.currency2, "Mail"),
        Features(R.drawable.currency, "Draft")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(featureList) { features ->
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                ),
                onClick = { }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(120.dp)
                        .padding( 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(features.image),
                        contentDescription = "Feature Logo",
                        Modifier
                            .background(color = Color(0xFFf8f2ff), shape = RoundedCornerShape(12.dp))
                            .size(50.dp)
                            .padding(10.dp),
                        tint = Color(0xFF121a83)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = features.title,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

