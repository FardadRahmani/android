package com.example.test.navigation

import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.test.model.Recipe
import com.example.test.model.RecipeCategory


class RecipeViewModel : ViewModel() {
    private val _recipeCategories = mutableStateListOf<RecipeCategory>()
    private val _recipes = mutableStateListOf<Recipe>()
    val recipeCategories: SnapshotStateList<RecipeCategory> = _recipeCategories
    val recipes: SnapshotStateList<Recipe> = _recipes

    fun addCategory(catName: String, @DrawableRes catThumb: Int, catDescription: String) {
        val newCategory = RecipeCategory(_recipeCategories.size,catName, catThumb, catDescription)
        _recipeCategories.add(newCategory)
    }

    fun addRecipe(catName: String, @DrawableRes thumb: Int, name: String, description: String) {
        val newRecipe = Recipe(_recipes.size,catName, thumb, name, description, false)
        _recipes.add(newRecipe)
    }
    fun favorRecipe (recipeId: Int){
        _recipes[recipeId] = _recipes[recipeId].copy(favored = true)

    }
    fun unfavorRecipe (recipeId: Int){
        if(_recipes[recipeId].favored)
        {_recipes[recipeId] = _recipes[recipeId].copy(favored = false)}

    }


    fun updateRecipe(recipeId: Int, updatedName: String, updatedContent: String) {
        val recipeIndex = _recipes.indexOfFirst { it.id == recipeId }
        if (recipeIndex != -1) {
            _recipes[recipeIndex] = _recipes[recipeIndex].copy(
                recipeName = updatedName,
                recipeDescription = updatedContent
            )
        }
    }


    fun deleteRecipe(recipeId: Int) {
        val recipeIndex = _recipes.indexOfFirst { it.id == recipeId }
        if (recipeIndex != -1) {
            _recipes.removeAt(recipeIndex)
            // Update the ids of the remaining notes
            for (i in recipeIndex until _recipes.size) {
                _recipes[i] = _recipes[i].copy(id = i + 1)
            }
        }
    }


}