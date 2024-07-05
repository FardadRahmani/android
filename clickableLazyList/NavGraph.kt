package com.example.mytest.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytest.R
import com.example.mytest.Screens
import com.example.mytest.MainActivity
import com.example.mytest.screens


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Nav(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "lazylistview" ){
        composable(route = "lazylistview"){
            ListLazyView(navController = navController, screens = screens)

        }
        //Set keywords for the passed arguments nameValue->name, ageValue->age
        composable(
            route = "singleview?screen={screenIndex}",
            arguments = listOf(
                navArgument(name = "screenIndex") {
                    type = NavType.IntType
                }
            )
        ) { backstackEntry ->
            val screenIndex = backstackEntry.arguments?.getInt("screenIndex") ?: -1
            if (screenIndex in screens.indices) {
                val screen = screens[screenIndex]
                SingleView(navController = navController, screen = screen)
            }
        }

        }
    }


