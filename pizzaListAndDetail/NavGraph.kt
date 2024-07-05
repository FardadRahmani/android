package com.example.newest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newest.imageId
import com.example.newest.ingredients
import com.example.newest.names
import com.example.newest.screens.ColumnItem
import com.example.newest.screens.DetailScreen
import com.example.newest.screens.MyApp

@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainscreen"){
        composable(route = "mainscreen"){
            MyApp(navController = navController, imageId = imageId, names = names, ingredients = ingredients)
        }
        composable(route= "detailscreen?itemIndex={itemIndex}",
            arguments = listOf(
                navArgument(name = "itemIndex"){
                    type = NavType.IntType
                    defaultValue = 1
                }
            )
        ){
            backstackEntry->
            DetailScreen(navController, itemIndex = backstackEntry.arguments?.getInt("itemIndex") ?: 1)

        }
    }

}
//"detailscreen?itemIndex={itemIndex}&painter={painter}&title={names}&ingredients={ingredients}&modifier={modifier}"