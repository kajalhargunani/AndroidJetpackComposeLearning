package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.Routes

//Learn State Hoisting concept of JetPack Compose
@Composable
fun WelcomeScreen(navController: NavHostController){
    var shouldShowWelcomeScreen by remember { mutableStateOf(true) }

    if (shouldShowWelcomeScreen) {
        OnboardingScreen(onContinueClicked = { shouldShowWelcomeScreen = false })
    } else {
        navController.navigate(Routes.ArticlesScreen.route)
    }
}
@Composable
private fun OnboardingScreen(onContinueClicked: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to JetPack Compose Tutorial")
            Button(onClick = onContinueClicked, modifier = Modifier.padding(8.dp)) {
                Text( text = "Let's Start")
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}