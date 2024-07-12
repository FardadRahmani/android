package com.example.test.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.R
import com.example.test.imageId
import com.example.test.navigation.NavItemState
import com.example.test.navigation.RecipeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(modifier: Modifier = Modifier,  viewModel: RecipeViewModel){

    var categoryName by rememberSaveable { mutableStateOf("") }
    var categoryDescription by rememberSaveable { mutableStateOf("") }



    var recipeName by rememberSaveable { mutableStateOf("") }
    var recipeDescription by rememberSaveable { mutableStateOf("") }




    val foodSel = ImageVector.vectorResource(id = R.drawable.food_selected)
    val foodUnselected = ImageVector.vectorResource(id = R.drawable.food_selected)


    val navItems = listOf(
        NavItemState(
            title = "Category",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
        ),
        NavItemState(
            title = "SortedRecs",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
        ),
        NavItemState(
            title = "Recipes",
            selectedIcon = foodSel,
            unselectedIcon = foodUnselected,
        ),
        NavItemState(
            title = "RowView",
            selectedIcon = foodSel,
            unselectedIcon = foodUnselected,
        ),

    )




    var catSelectState by rememberSaveable {
        mutableStateOf("1")
    }

    var actionButtonClicked by rememberSaveable {
        mutableStateOf(false)
    }

    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Top App Bar", fontWeight = FontWeight.Bold)
                    }
                },
                modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),

                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu icon")

                    }
                },

                actions ={
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Account")
                    }
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "ShoppingCart icon" )
                    }
                },

                colors =TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFE0A9A5)
                )

            )
        },

        bottomBar = {NavigationBar(
            modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(20.dp)),
            containerColor = Color(0xFFE0A9A5)
        ) {





            NavigationBarItem(
                selected = bottomNavState == 0,

                onClick = {
                    bottomNavState = 0

                },
                icon = {
                    Icon(
                        imageVector = if (bottomNavState == 0) navItems[0].selectedIcon
                        else navItems[0].unselectedIcon,
                        contentDescription = navItems[0].title
                    )
                },
                label = { Text(text = navItems[0].title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF552A27),
                    selectedTextColor = Color(0xFF63332F),
                    indicatorColor = Color(0xFFBB7E7A)
                )
            )

            NavigationBarItem(
                selected = bottomNavState == 1,

                onClick = {
                    bottomNavState = 1

                },
                icon = {
                    Icon(
                        imageVector = if (bottomNavState == 1) navItems[1].selectedIcon
                        else navItems[1].unselectedIcon,
                        contentDescription = navItems[1].title
                    )
                },
                label = { Text(text = navItems[1].title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF552A27),
                    selectedTextColor = Color(0xFF63332F),
                    indicatorColor = Color(0xFFBB7E7A)
                )
            )

            NavigationBarItem(
                selected = bottomNavState == 2,

                onClick = {
                    bottomNavState = 2

                },
                icon = {
                    Icon(
                        imageVector = if (bottomNavState == 2) navItems[2].selectedIcon
                        else navItems[2].unselectedIcon,
                        contentDescription = navItems[2].title
                    )
                },
                label = { Text(text = navItems[2].title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF552A27),
                    selectedTextColor = Color(0xFF63332F),
                    indicatorColor = Color(0xFFBB7E7A)
                )
            )


            NavigationBarItem(
                selected = bottomNavState == 3,

                onClick = {
                    bottomNavState = 3

                },
                icon = {
                    Icon(
                        imageVector = if (bottomNavState == 3) navItems[3].selectedIcon
                        else navItems[3].unselectedIcon,
                        contentDescription = navItems[3].title
                    )
                },
                label = { Text(text = navItems[3].title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF552A27),
                    selectedTextColor = Color(0xFF63332F),
                    indicatorColor = Color(0xFFBB7E7A)
                )
            )



























/*Original
            navItems.forEachIndexed { index, navItem ->


                    NavigationBarItem(
                        selected = bottomNavState == index,

                        onClick = {
                            bottomNavState = index

                        },
                        icon = {
                            Icon(
                                imageVector = if (bottomNavState == index) navItem.selectedIcon
                                else navItem.unselectedIcon,
                                contentDescription = navItem.title
                            )
                        },
                        label = { Text(text = navItem.title) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF552A27),
                            selectedTextColor = Color(0xFF63332F),
                            indicatorColor = Color(0xFFBB7E7A)
                        )
                    )
                }
*/








        }},

        floatingActionButton = {
                               FloatingActionButton(onClick = {
                                                              actionButtonClicked=true
                                                              },
                                   containerColor = Color(0xFFFF9800),
                                   shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp)
                                   ) {
                                   Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                               }

        } ) {contentPadding->

        Column(
            modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Site: ${navItems[bottomNavState].title}", fontSize = 44.sp, fontWeight = FontWeight.Bold)
            //I want to add content here





            fun navigateToRecipeSortedScreen(catSelect: String) {
                bottomNavState = 1 // Since the index of "RecipesSorted" is 1 in your navItems list

                catSelectState = catSelect
            }


            //Category Screen
            if(bottomNavState==0)
                CategoryScreen(viewModel,navigateToRecipeSortedScreen = ::navigateToRecipeSortedScreen)
            //RecipeSortedScreen
            else if(bottomNavState==1)
                RecipeSortedScreen(catName = catSelectState, viewModel = viewModel)
            //RecipeScreen
            else if (bottomNavState==2)
                RecipeScreen(viewModel= viewModel)

            else if (bottomNavState==3){
                RowViewScreen(viewModel)
            }



            //ActionButton for new Category
            if (actionButtonClicked && bottomNavState==0){
                AlertDialog(onDismissRequest = { actionButtonClicked = false },
                    confirmButton = {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Button(onClick = {
                                if(categoryName.isNotBlank() && categoryDescription.isNotBlank()){
                                    if (categoryName=="Fisch")
                                        viewModel.addCategory(categoryName, imageId[0], categoryDescription)
                                    else if (categoryName=="Steak")
                                        viewModel.addCategory(categoryName, imageId[1], categoryDescription)
                                    else if (categoryName=="Finger-Food")
                                        viewModel.addCategory(categoryName, imageId[2], categoryDescription)
                                    categoryName=""
                                    categoryDescription=""
                                    actionButtonClicked = false


                                }
                            }) {
                                Text("Add Category")
                            }
                            Button(onClick = {
                                actionButtonClicked = false
                            }) {
                                Text("Cancel")
                            }

                        }
                    },
                    title = {Text("Add a Recipe-Category")},
                    text = {
                        Column {
                            OutlinedTextField(value = categoryName,
                                onValueChange = { categoryName = it },
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                            OutlinedTextField(value = categoryDescription,
                                onValueChange = { categoryDescription = it },
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                        }

                    }
                )
            }

            //ActionButton for new Recipe
            if (actionButtonClicked && bottomNavState==1){
                AlertDialog(onDismissRequest = { actionButtonClicked = false },
                    confirmButton = {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween){
                            Button(onClick = {
                                if(recipeName.isNotBlank() && recipeDescription.isNotBlank()){

                                    when(catSelectState){

                                        "Fisch" -> viewModel.addRecipe(catSelectState, imageId[0], recipeName, recipeDescription)
                                        "Steak" -> viewModel.addRecipe(catSelectState, imageId[1], recipeName, recipeDescription)
                                        "Finger-Food" -> viewModel.addRecipe(catSelectState, imageId[2], recipeName, recipeDescription)
                                        "Pizzen" -> viewModel.addRecipe(catSelectState, imageId[3], recipeName, recipeDescription)
                                        "Nudeln" -> viewModel.addRecipe(catSelectState, imageId[4], recipeName, recipeDescription)
                                        "Desserts" -> viewModel.addRecipe(catSelectState, imageId[5], recipeName, recipeDescription)



                                    }



                                    recipeName=""
                                    recipeDescription=""
                                    actionButtonClicked = false


                                }
                            }) {
                                Text("Add Recipe")
                            }
                            Button(onClick = {
                                actionButtonClicked = false
                            }) {
                                Text("Cancel")
                            }

                        }
                    },
                    title = {Text("Add a new $catSelectState")},
                    text = {
                        Column {
                            OutlinedTextField(value = recipeName,
                                onValueChange = { recipeName = it },
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )

                            OutlinedTextField(value = recipeDescription,
                                onValueChange = { recipeDescription = it },
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            )
                        }

                    }
                )
            }













        }
    }




}


