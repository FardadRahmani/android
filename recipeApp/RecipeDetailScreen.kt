package com.example.test.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
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
import com.example.test.model.Recipe
import com.example.test.navigation.RecipeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailScreen(recipeId: Int, viewModel: RecipeViewModel) {
    //isCardClicked=true
    val recipe : Recipe = viewModel.recipes.get(recipeId)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(470.dp),
                // shape = CutCornerShape(20.dp)
                elevation = CardDefaults.cardElevation(10.dp),
                //border = BorderStroke(3.dp,Color.Gray)
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                onClick = { }

            ) {
                Image(
                    painter = painterResource(id = recipe.recipeThumb),
                    contentDescription = null,
                    Modifier.wrapContentHeight(Alignment.CenterVertically)
                )
                Text(
                    text = recipe.recipeName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = recipe.recipeDescription,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(6.dp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )

            }

        }
    }

}










/*
else if (catName=="Pizzen"){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn() {


                items(items = viewModel.recipes.filter { it.categoryName=="Pizzen" }) { item ->
                    Card(
                        modifier = Modifier
                            .width(200.dp)
                            .height(270.dp),
                        // shape = CutCornerShape(20.dp)
                        elevation = CardDefaults.cardElevation(10.dp),
                        //border = BorderStroke(3.dp,Color.Gray)
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        onClick = { }

                    ) {
                        Image(
                            painter = painterResource(id = item.recipeThumb),
                            contentDescription = null,
                            Modifier.wrapContentHeight(Alignment.CenterVertically)
                        )
                        Text(
                            text = item.recipeName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(10.dp)
                        )
                        Text(
                            text = item.recipeDescription,
                            fontSize = 13.sp,
                            modifier = Modifier.padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Gray
                        )

                    }


                }

            }

        }
    }





}*/