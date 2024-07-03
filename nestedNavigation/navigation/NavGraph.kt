package com.example.nestednavigation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.nestednavigation.navigation.Screens
import com.example.nestednavigation.screens.ForgetPassScreen
import com.example.nestednavigation.screens.HomeScreen
import com.example.nestednavigation.screens.LoginScreen
import com.example.nestednavigation.screens.RegisterScreen
import com.example.nestednavigation.screens.ScreenA
import com.example.nestednavigation.screens.ScreenB

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.AuthRoute.route) {

        authGraph(navController)

        appGraph(navController)


    }
}