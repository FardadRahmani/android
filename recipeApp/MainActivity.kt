package com.example.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.test.navigation.RecipeViewModel
import com.example.test.screens.MyApp
import com.example.test.ui.theme.TestTheme


val imageId = arrayOf(
    R.drawable.c1,//fish
    R.drawable.c2,//steak
    R.drawable.c3,//finger
    R.drawable.pizzencat, //Pizzen
    R.drawable.nudelcat, //Nudeln
    R.drawable.dessertscat,
)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel = viewModel<RecipeViewModel>()
            viewModel.addCategory(catName = "Pizzen", catThumb =  R.drawable.pizzencat, catDescription = "Pizzen sind italienische Sandwiches")
            viewModel.addCategory(catName = "Nudeln", catThumb =  R.drawable.nudelcat, catDescription = "Nudelgerichte sind weltweit beliebt")
            viewModel.addCategory(catName = "Desserts", catThumb =  R.drawable.dessertscat, catDescription = "Desserts sind leichte kleine Nachspeisen")

            viewModel.addRecipe(catName = "Desserts", thumb =  R.drawable.dessertchoco, name= "Choco-Glass", description = "ein kleiner Tiramisu")
            viewModel.addRecipe(catName = "Desserts", thumb =  R.drawable.dessertkirsch, name= "Kirsch-Kuchen", description = "ein kleiner Kuchen mit Kirsch")
            viewModel.addRecipe(catName = "Desserts", thumb =  R.drawable.dessertpist, name= "Pistachio-Cake", description = "ein kleiner Kuchen mit Pistazien")


            viewModel.addRecipe(catName = "Nudeln", thumb =  R.drawable.nudelbolo, name= "Fusili-Bolognese", description = "ein italienisches Nudelgericht")
            viewModel.addRecipe(catName = "Nudeln", thumb =  R.drawable.nudelcheese, name= "Rigatoni-Cheese", description = "ein italienisches Nudelgericht")
            viewModel.addRecipe(catName = "Nudeln", thumb =  R.drawable.nudelchin, name= "Chinese-Nudeln", description = "ein chinesisches Nudelgericht")


            viewModel.addRecipe(catName = "Pizzen", thumb =  R.drawable.p1, name= "Pizza-Salami", description = "Pizza mit Salami")
            viewModel.addRecipe(catName = "Pizzen", thumb =  R.drawable.p2, name= "Pizza-Mozzarella", description = "Pizza mit Mozzarella")
            viewModel.addRecipe(catName = "Pizzen", thumb =  R.drawable.p3, name= "Pizza-Hack", description = "Pizza mit Hackfleisch")
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(viewModel = viewModel)
                }
            }
        }
    }
}









/*
data class NavItemState(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val messages: Int
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val items = listOf(
        NavItemState(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = false,
            messages = 0
        ),
        NavItemState(
            title = "Inbox",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasBadge = false,
            messages = 12
        ),
        NavItemState(
            title = "Account",
            selectedIcon = Icons.Filled.Face,
            unselectedIcon = Icons.Outlined.Face,
            hasBadge = true,
            messages = 0
        )
    )
    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center) {
                        Text(text = "Top App Bar", fontWeight = FontWeight.Bold)
                    }

                },
                modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                navigationIcon = {
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu icon" )
                    }

                },
                actions = {
                    IconButton(onClick = {  }) {
                        BadgedBox(badge = { Badge(
                            modifier.size(10.dp)
                        ) {
                        }}) {
                            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "Fav icon" )
                        }

                    }
                    IconButton(onClick = {  }) {
                        Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "ShoppingCart icon" )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFE0A9A5)
                )
            )
        },
        bottomBar = {
            NavigationBar(
                modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                containerColor = Color(0xFFE0A9A5)
            ) {
                items.forEachIndexed { index, item ->


                    NavigationBarItem(

                        selected = bottomNavState == index,
                        onClick = { bottomNavState = index },
                        icon = {
                            BadgedBox(badge = {
                                if (item.hasBadge) Badge {}
                                if (item.messages != 0) Badge {
                                    Text(text = "${item.messages}")
                                }
                            }) {
                                Icon(
                                    imageVector = if (bottomNavState == index) item.selectedIcon
                                    else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }

                        },
                        label = { Text(text = item.title) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF552A27),
                            selectedTextColor = Color(0xFF63332F),
                            indicatorColor = Color(0xFFBB7E7A)
                        )
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = Color(0xFFFF9800),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp)
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            }
        }
    ) { contentPadding ->

        Column(
            modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = items[bottomNavState].title, fontSize = 44.sp, fontWeight = FontWeight.Bold)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        MyApp()
    }
}

 */