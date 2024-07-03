package com.example.nestednavigation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.nestednavigation.screens.ForgetPassScreen
import com.example.nestednavigation.screens.HomeScreen
import com.example.nestednavigation.screens.LoginScreen
import com.example.nestednavigation.screens.RegisterScreen
import com.example.nestednavigation.screens.ScreenA
import com.example.nestednavigation.screens.ScreenB


fun NavGraphBuilder.appGraph(navController: NavController){
    navigation(startDestination = Screens.ScreenHomeRoute.route, route = Screens.AppRoute.route){
        composable(route = Screens.ScreenHomeRoute.route){
            HomeScreen(navController = navController)
        }

        composable(route = Screens.ScreenARoute.route){
            ScreenA(navController = navController)
        }
        composable(route = Screens.ScreenBRoute.route){
            ScreenB(navController = navController)
        }
    }
}