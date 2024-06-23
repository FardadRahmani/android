package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame() // Call the CaptainGame composable function here

                }
            }
        }
    }

    @Composable
    fun CaptainGame() {
        val treasuresFound = remember { mutableStateOf(0) }
        val direction = remember { mutableStateOf("North") }
        val stormOrTreasure = remember { mutableStateOf("") }

        Column {
            //Here all the UI elements will be stacked below each other
            Text(text = "Treasures found: ${treasuresFound.value}")
            Text(text = "Current direction: ${direction.value}")



            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Button(onClick = {
                    direction.value = "North"
                    if (Random.nextBoolean()) {
                        treasuresFound.value += 1
                        stormOrTreasure.value = "Treasure Found"
                    } else{
                        stormOrTreasure.value = "Storm ahead"
                    }
                }) {
                    Text("Sail North")

                }

            }

            Row {

                Column(
                    modifier = Modifier.width(280.dp),

                    horizontalAlignment = AbsoluteAlignment.Left
                ) {
                    Button(onClick = {
                        direction.value = "West"
                        if (Random.nextBoolean()) {
                            treasuresFound.value += 1
                            stormOrTreasure.value = "Treasure Found"
                        } else {
                            stormOrTreasure.value = "Storm ahead"
                        }
                    }) {
                        Text("Sail West")

                    }

                }


                Column(

                    horizontalAlignment = AbsoluteAlignment.Right
                ) {
                    Button(onClick = {
                        direction.value = "East"
                        if (Random.nextBoolean()) {
                            treasuresFound.value += 1
                            stormOrTreasure.value = "Treasure Found"
                        } else {
                            stormOrTreasure.value = "Storm ahead"
                        }

                    }) {
                        Text("Sail East")


                    }

                }



            }

            Column(

                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    direction.value = "South"
                    if (Random.nextBoolean()) {
                        treasuresFound.value += 1
                        stormOrTreasure.value = "Treasure Found"
                    } else {
                        stormOrTreasure.value = "Storm ahead"
                    }
                }) {
                    Text("Sail South")

                }
            }
            Text(text = "Storm or Treasure: ${stormOrTreasure.value}")
        }

    }
}

