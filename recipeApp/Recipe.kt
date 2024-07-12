package com.example.test.model

import androidx.annotation.DrawableRes

data class RecipeCategory(val id: Int,
                          val categoryName: String,
                          @DrawableRes val categoryThumb: Int,
                          val categoryDescription : String)

data class Recipe(  val id: Int,
                    val categoryName: String,
                    @DrawableRes val recipeThumb: Int,
                    val recipeName : String,
                    val recipeDescription : String,
                    val favored: Boolean)