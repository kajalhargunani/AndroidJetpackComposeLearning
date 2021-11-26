package com.example.myapplication.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.Routes


@Composable
 fun ArticlesScreen(navHostController: NavHostController) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = listOf("Layouts","Theming","Animation","Testing","State","Accessibility")) { name ->
            Article(name = name, navHostController)
        }
    }
}

@Composable
private fun Article(name: String, navHostController: NavHostController) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name, navHostController)
    }
}

@Composable
private fun CardContent(name: String, navHostController: NavHostController) {
    //Learn State concept of JetPack Compose
    var expanded by remember { mutableStateOf(false) }

    //Learn Jetpack Compose Animation and layouts
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )

            Button(onClick = { navHostController.navigate(Routes.TakeTestScreen.route)} , modifier = Modifier.padding(8.dp)) {
                Text( text = "Take Test")
                Icon(
                    imageVector = Icons.Default.Assignment,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            if (expanded) {
                Text(
                    text = descriptionAboutJetpackComposeTopics(name = name),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(com.example.myapplication.R.string.show_less)
                } else {
                    stringResource(com.example.myapplication.R.string.show_less)
                }

            )
        }
    }
}
fun descriptionAboutJetpackComposeTopics(name: String) : String{
    return when(name) {
        "State" ->  "State in an app is any value that can change over time. This is a very broad definition and encompasses everything from a Room database to a variable on a class."
        "Testing" -> "Testing UIs or screens is used to verify the correct behavior of your Compose code, improving the quality of your app by catching errors early in the development process."
        "Animation" -> "Jetpack Compose provides powerful and extensible APIs that make it easy to implement various animations in your app's UI. This document describes how to use these APIs as well as which API to use depending on your animation scenario."
        "Theming" -> "Jetpack Compose makes it easy to give your app a consistent look and feel with theming.\n" +
                "\n" +
                "The following pages provide details on how to design and implement your themes:\n" +
                "\n" +
                "Material Theming: Learn how to customize Compose's implementation of Material Design to fit your product's brand.\n" +
                "Custom design systems: Learn how to implement a custom design system in Compose, and how to adapt existing Material composables to handle this.\n" +
                "Anatomy of a theme: Learn about the lower-level constructs and APIs used by MaterialTheme and custom design systems.t"
        "Layouts" ->  "Jetpack Compose provides a declarative way of building the UI of the Android app. Layouts are an essential component for creating UI, and Jetpack Compose already supports a few of them."
        "Accessibility" -> "People with impaired vision, color blindness, impaired hearing, impaired dexterity, cognitive disabilities, and many other disabilities use Android devices to complete tasks in their day-to-day lives. When you develop apps with accessibility in mind, you make the user experience better, particularly for users with these and other accessibility needs"
        else -> "Jetpack compose topics"
    }
}