package com.example.newest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newest.screens.NewNoteScreen
import com.example.newest.screens.NoteDetailScreen
import com.example.newest.screens.NoteListScreen

@Composable
fun Nav(viewModel: NoteViewModel){


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "notelistscreen")
    {

        composable (route = "notelistscreen",

        ){
            backstackEntry->
            NoteListScreen(navController = navController,
                viewModel = viewModel)
        }
        composable (route = "newnotescreen"){

            NewNoteScreen(navController = navController, viewModel = viewModel)
        }
        composable (route = "notedetailscreen?id={id}",
            arguments = listOf(
                navArgument(name = "id"){
                    type = NavType.IntType

                }
            )
        )
        {
            backstackEntry ->
            val noteId = backstackEntry.arguments?.getInt("id")
            if (noteId != null) {
                NoteDetailScreen(
                    navController = navController,
                    viewModel = viewModel,
                    noteId = noteId
                )
            }

        }


    }



}