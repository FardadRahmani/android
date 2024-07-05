package com.example.mytest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mytest.navigation.ListLazyView
import com.example.mytest.navigation.Nav
import com.example.mytest.ui.theme.MyTestTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

public val screens = listOf<Screens>(
    Screens(name= "Persepolis", id = R.drawable.persepolis, description = "A very beautiful Monument from old Persia"),
    Screens(name= "Porta Nigra", id = R.drawable.portanigra, description = "A very beautiful Monument from Porta Nigra"),
    Screens(name= "Salzburg", id = R.drawable.salzburg, description = "A very beautiful Monument from Salzburg"),
    Screens(name= "Valencia", id = R.drawable.valencia, description = "A very beautiful Monument from Valencia"),
    Screens(name= "Bratislava", id = R.drawable.bratislava, description = "A very beautiful Monument from Bratislava")
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyTestTheme {
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


/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTestTheme  {
        MyApp(screens:)
    }
}
*/
/*
@Composable
fun MyCard() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {


        Card(
            modifier = Modifier
                .width(200.dp)
                .height(270.dp),
            // shape = CutCornerShape(20.dp)
            elevation = CardDefaults.cardElevation(10.dp),
            //border = BorderStroke(3.dp,Color.Gray)
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.persepolis),
                    contentDescription = "null"
                )
                Text(
                    text = "Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make ",
                    fontSize = 13.sp,
                    modifier = Modifier.padding(6.dp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTestTheme  {
        MyCard()
    }
}
*/












/*
@Composable
fun MyApp() {
    Box(modifier = Modifier
        .background(Color.White)
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(modifier = Modifier
            .background(Color.Yellow)
            .width(250.dp)
            .height(250.dp)
            , contentAlignment = Alignment.BottomCenter
        ) {

            Box(modifier = Modifier
                .background(Color.Green)
            ) {

                Text(text = "Subscribe please", fontSize = 38.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    MyApp()
}*/


















/*
@Composable
fun ImageExample(){
    Column(Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.persepolis) ,
            contentDescription = "pic",
            Modifier
                .padding(10.dp)
                //.size(200.dp)
                .width(295.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(2.dp, Color.Red, shape = RoundedCornerShape(16.dp)),
            // alignment = Alignment.TopCenter
            contentScale = ContentScale.FillWidth,
            //alpha = .2f
        )
        Image(painter = painterResource(id = R.drawable.persepolis) ,
            contentDescription = "pic",
            Modifier
                .padding(10.dp)
                //.size(200.dp)
                .width(295.dp)
                .height(200.dp)
                .clip(CutCornerShape(16.dp))
                .border(2.dp, Color.Red, shape = CutCornerShape(16.dp)),
             //alignment = Alignment.TopCenter
            contentScale = ContentScale.FillWidth,
            //alpha = .2f
        )
        Image(painter = painterResource(id = R.drawable.persepolis) ,
            contentDescription = "pic",
            Modifier
                .padding(10.dp)
                .size(250.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Red, shape = CircleShape),
            // alignment = Alignment.TopCenter
            contentScale = ContentScale.Crop,
            //alpha = .2f
        )

    }
}*/












/*
@Composable
fun MyCard() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .width(200.dp)
                .height(270.dp),
            // shape = CutCornerShape(20.dp)
            elevation = CardDefaults.cardElevation(10.dp),
            //border = BorderStroke(3.dp,Color.Gray)
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.persepolis),
                    contentDescription = "null"
                )
                Text(
                    text = "Title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make ",
                    fontSize = 13.sp,
                    modifier = Modifier.padding(6.dp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )
            }

        }
    }
}*/
