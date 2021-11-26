package com.example.myapplication

sealed class Routes(val route: String) {
    object WelcomeScreen : Routes("welcome")
    object ArticlesScreen : Routes("topics")
    object TakeTestScreen : Routes("test")
}