package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.*

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.ArticlesScreen
import com.example.myapplication.screens.TakeTestScreen
import com.example.myapplication.screens.WelcomeScreen
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                StartApplication()
            }
        }
    }
}

//Learn Jetpack Compose Navigation.
@Composable
fun StartApplication() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WelcomeScreen.route) {
        composable(Routes.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.ArticlesScreen.route) {
            ArticlesScreen(navHostController = navController)
        }
        composable(Routes.TakeTestScreen.route) {
            TakeTestScreen()
        }
    }
}

