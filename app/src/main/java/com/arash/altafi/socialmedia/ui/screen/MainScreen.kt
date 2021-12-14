package com.arash.altafi.socialmedia.ui.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arash.altafi.socialmedia.ui.components.BottomNavigationView
import com.arash.altafi.socialmedia.ui.components.TopAppView

@Composable
fun MainScreen() {

    var fullScreen by remember { mutableStateOf(false) }
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            if (!fullScreen) TopAppView()
        },
        bottomBar = {
            if (!fullScreen) BottomNavigationView(navController)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") {
                HomeScreen(navController = navController)
                fullScreen = false
            }
            composable("search") {
                SearchScreen()
                fullScreen = false
            }
            composable("add") {
                AddPostScreen()
                fullScreen = false
            }
            composable("activities") {
                ActivitiesScreen()
                fullScreen = false
            }
            composable("profile") {
                ProfileScreen()
                fullScreen = false
            }
            composable(
                route= "showStory/{index}",
                arguments = listOf(navArgument("index") {
                    type = NavType.IntType
                })
            ) { backStack ->
                ShowStoryScreen(backStack.arguments?.get("index") as Int)
                fullScreen = true
            }
        }
    }
}