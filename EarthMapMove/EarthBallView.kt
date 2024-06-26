package com.example.earthball

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun ViewEarthBall(earthView : EarthBallViewModel) {

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "North Value: ${earthView.north.value}")
        Button(onClick = { earthView.goNorth() }) {
            Text(text = "Go North")

        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Column {
                Text(text = "West Value: ${earthView.west.value}")
                Button(onClick = { earthView.goWest() }) {
                    Text(text = "Go West")

                }
            }

            Column {
                Text(text = "East Value: ${earthView.east.value}")
                Button(onClick = { earthView.goEast() }) {
                    Text(text = "Go East")

                }
            }
        }

        Text(text = "South Value: ${earthView.south.value}")
        Button(onClick = { earthView.goSouth() }) {
            Text(text = "Go South")

        }
    }

}

