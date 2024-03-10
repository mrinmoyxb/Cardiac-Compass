package com.example.heartdiseasedetetectionapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heartdiseasedetetectionapp.View.HomeScreen.HomeScreenFinal.HomeScreen
import com.example.heartdiseasedetetectionapp.View.ResultScreen.ResultScreenFinal.ResultScreen

@Composable
fun MainScreen(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homeScreen"){

        composable(route = "homeScreen"){
            HomeScreen(navController)
        }
        composable(route = "resultScreen"){
            ResultScreen()
        }
    }
}