package com.example.test.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.navigation.RecipeViewModel

//var isCardClicked = false

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen( viewModel: RecipeViewModel, navigateToRecipeSortedScreen: (String) -> Unit  ){



    var catSelectState by rememberSaveable {
        mutableStateOf("1")
    }

    if (catSelectState=="1") {
        //isCardClicked=false
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

                    items(items = viewModel.recipeCategories) { item ->
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
                            onClick = {
                                catSelectState = item.categoryName
                                navigateToRecipeSortedScreen(catSelectState)


                            }

                        ) {
                            Image(
                                painter = painterResource(id = item.categoryThumb),
                                contentDescription = null,
                                Modifier.wrapContentHeight(Alignment.CenterVertically)
                            )
                            Text(
                                text = item.categoryName,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                modifier = Modifier.padding(10.dp)
                            )
                            Text(
                                text = item.categoryDescription,
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
    } else {

        RecipeSortedScreen(catName = catSelectState, viewModel = viewModel)


    }
}