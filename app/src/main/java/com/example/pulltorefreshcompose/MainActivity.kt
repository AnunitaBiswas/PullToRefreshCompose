package com.example.pulltorefreshcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pulltorefreshcompose.lazyExample.Item
import com.example.pulltorefreshcompose.lazyExample.LazyColumnScreen
import com.example.pulltorefreshcompose.lazyExample.LazyGridScreen
import com.example.pulltorefreshcompose.lazyExample.LazyRowScreen
import com.example.pulltorefreshcompose.ui.theme.PullToRefreshComposeTheme

class MainActivity : ComponentActivity() {

    companion object {
        val items: List<Item> = listOf(
            Item(
                title = "item1",
                image = R.drawable.image1
            ),
            Item(
                title = "item2",
                image = R.drawable.image2
            ),
            Item(
                title = "item3",
                image = R.drawable.image3
            ),
            Item(
                title = "item1",
                image = R.drawable.image1
            ),
            Item(
                title = "item2",
                image = R.drawable.image2
            ),
            Item(
                title = "item3",
                image = R.drawable.image3
            ),
            Item(
                title = "item1",
                image = R.drawable.image1
            ),
            Item(
                title = "item2",
                image = R.drawable.image2
            ),
            Item(
                title = "item3",
                image = R.drawable.image3
            )
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PullToRefreshComposeTheme {
                /* PullToRefreshScreen() */

                val navHostController = rememberNavController()
                NavHost(
                    navController = navHostController,
                    startDestination = "home_screen"
                ) {

                    composable("home_screen") {
                        HomeScreen(navHostController = navHostController)
                    }
                    composable("lazy_row_screen") {
                        LazyRowScreen()
                    }
                    composable("lazy_column_screen") {
                        LazyColumnScreen()
                    }
                    composable("lazy_Grid_screen") {
                        LazyGridScreen()
                    }
                }

            }
        }
    }
}

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            navHostController.navigate("lazy_row_screen")
        }) {
            Text(text = "Lazy Row")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navHostController.navigate("lazy_column_screen")
        }) {
            Text(text = "Lazy Column")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navHostController.navigate("lazy_Grid_screen")
        }) {
            Text(text = "Lazy Grid")
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}




















