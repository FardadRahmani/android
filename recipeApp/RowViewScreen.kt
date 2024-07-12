package com.example.test.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.navigation.RecipeViewModel


@Composable
fun RowViewScreen(viewModel: RecipeViewModel){


    LazyColumn(contentPadding = PaddingValues(15.dp)){

        items(viewModel.recipeCategories.size){
            ColumnItemUI(viewModel, it)
        }

    }

}

@Composable
fun ColumnItemUI(viewModel: RecipeViewModel, index: Int) {


    viewModel.recipes.filter { it.categoryName==viewModel.recipeCategories[index].categoryName }.size

    Card(modifier = Modifier.padding(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        )) {
        Text(
            text = viewModel.recipeCategories[index].categoryName,
            modifier = Modifier.padding(12.dp),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFC107)
        )
        LazyRow(contentPadding = PaddingValues(12.dp)){
            items(viewModel.recipes.filter { it.categoryName==viewModel.recipeCategories[index].categoryName }.size){
                RowItemUI(viewModel, it, categoryName=viewModel.recipeCategories[index].categoryName )

            }

        }

    }


}

@Composable
fun RowItemUI(viewModel: RecipeViewModel, rowIndex: Int, categoryName: String) {

    Box(
        modifier = Modifier
            .height(200.dp)
            .width(160.dp)
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xF1201E1F))
    ){
        Image(painter = painterResource(id = viewModel.recipes.filter { it.categoryName==categoryName }[rowIndex].recipeThumb),
            contentDescription = "",
            modifier = Modifier.fillMaxSize())
    }

}
