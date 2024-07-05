package com.example.newest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newest.imageId
import com.example.newest.ingredients
import com.example.newest.names

@Composable
fun DetailScreen(
    navController: NavController,
    itemIndex: Int,

) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier
                .width(250.dp)
                .height(470.dp),
            // shape = CutCornerShape(20.dp)
            elevation = CardDefaults.cardElevation(16.dp),
            //border = BorderStroke(3.dp,Color.Gray)
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ){
            Column {
                Image(painter = painterResource(id = imageId[itemIndex]), contentDescription = names[itemIndex])
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = names[itemIndex], fontWeight= FontWeight.Bold, fontSize = 24.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = ingredients[itemIndex])


            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { navController.navigate("mainscreen") }) {
            Text(text = "Go Back")

        }


    }

}