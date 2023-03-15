package com.hypoballad.dialogdojo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hypoballad.dialogdojo.presentation.practice.detail.PracticeDetailScreen
import com.hypoballad.dialogdojo.presentation.practice.list.PracticeHistoryScreen
import com.hypoballad.dialogdojo.ui.theme.DialogDojoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogDojoTheme {
                DialogDojoApp()
            }
        }
//        setContent {
//            DialogDojoTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    // Greeting("Android")
//                    // PracticeDetailScreen()
//                    DialogDojoApp()
//                }
//            }
//        }
    }
}

@Composable
private fun DialogDojoApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "practices") {
        composable(route = "practices") {
            PracticeHistoryScreen{ id ->
                    navController.navigate("practices/$id")
            }
        }
        composable(
            route = "practices/{practice_id}",
            arguments = listOf(navArgument("practice_id") {
                type = NavType.IntType
            })
        ) {
            PracticeDetailScreen()
        }

    }

}


//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    DialogDojoTheme {
//        Greeting("Android")
//    }
//}