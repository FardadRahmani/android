package com.example.newest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newest.navigation.Nav
import com.example.newest.screens.ColumnItem
import com.example.newest.screens.MyApp
import com.example.newest.ui.theme.NewestTheme

val imageId = arrayOf(
    R.drawable.p1,
    R.drawable.p2,
    R.drawable.p3,
    R.drawable.p4,
    R.drawable.p5,
    R.drawable.p6
)

val names = arrayOf(
    "Peperoni",
    "Vegan",
    "FourCheese",
    "Margaritta",
    "American",
    "Mexican"
)

val ingredients = arrayOf(
    "Tomato sos, cheese, oregano, peperoni",
    "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
    "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
    "Tomato sos, cheese, oregano, bazillion",
    "Tomato sos, cheese, oregano, green paprika, red beans",
    "Tomato sos, cheese, oregano, corn, jalapeno, chicken"
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Nav()
                }
            }
        }
    }
}
