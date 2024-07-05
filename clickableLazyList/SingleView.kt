package com.example.mytest.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mytest.Screens
import com.example.mytest.MainActivity
import com.example.mytest.screens


@Composable
fun SingleView(navController: NavController, screen:Screens) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


        Card(
            modifier = Modifier
                .width(250.dp)
                .height(370.dp),
            // shape = CutCornerShape(20.dp)
            elevation = CardDefaults.cardElevation(10.dp),
            //border = BorderStroke(3.dp,Color.Gray)
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )


        ) {
            Image(
                painter = painterResource(id = screen.id),
                contentDescription = null,
                Modifier.wrapContentHeight(Alignment.CenterVertically)
            )
            Text(
                text = screen.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = screen.description,
                fontSize = 13.sp,
                modifier = Modifier.padding(6.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray
            )


        }

        Button(onClick = { navController.navigate("lazylistview") }) {
            Text(text = "Go to Overview")

        }


    }
}