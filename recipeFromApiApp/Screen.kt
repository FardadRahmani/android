package com.example.myrecipeapp

sealed class Screen(val route : String) {
    object RecipeScreen:Screen("recipescreen")
    //from {categoryId}
    object DetailScreen:Screen("detailscreen/{categoryId}") {
        fun createRoute(categoryId: String) = "detailscreen/$categoryId"
    }
}