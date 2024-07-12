package com.example.test.screens

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
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.example.test.navigation.RecipeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(catName: String= "1",viewModel: RecipeViewModel) {
    //isCardClicked=false
    var isDetailClicked by rememberSaveable {
        mutableStateOf(false)
    }
    var recId by rememberSaveable {
        mutableStateOf(100)
    }

    if(isDetailClicked && recId != 100){
        RecipeDetailScreen(recipeId = recId, viewModel = viewModel)
    }







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
                LazyColumn(
                    state = rememberLazyListState()
                ) {

                    items(items = viewModel.recipes) { item ->
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
                                isDetailClicked=true
                                recId= item.id
                            }

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

}
