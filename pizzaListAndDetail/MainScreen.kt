package com.example.newest.screens

import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.newest.names


@Composable
fun MyApp(
    navController: NavController,
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        contentPadding = PaddingValues(
            16.dp
        )
    ) {
        val itemCount = imageId.size
        items(itemCount) { item ->
            ColumnItem(
                navController = navController,
                itemIndex = item,
                painter = imageId,
                title = names,
                ingredients = ingredients,
                modifier
            )
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnItem(
    navController: NavController,
    itemIndex: Int,
    painter: Array<Int>,
    title: Array<String>,
    ingredients: Array<String>,
    modifier: Modifier
) {
    Card(
        onClick = {navController.navigate("detailscreen?itemIndex=$itemIndex") },
        modifier
            .padding(10.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp),


    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = title[itemIndex],
                modifier.size(140.dp)
            )
            Column(modifier.padding(12.dp)) {
                Text(text = title[itemIndex],
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp)
                Text(text = ingredients[itemIndex],
                    fontSize = 18.sp)
            }
        }

    }
}