package com.example.heartdiseasedetetectionapp.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.heartdiseasedetetectionapp.View.HomeScreen.HomeScreenFinal.HomeScreen
import com.example.heartdiseasedetetectionapp.View.ResultScreen.ResultScreenFinal.ResultScreen
import com.example.heartdiseasedetetectionapp.ViewModel.HeartDiseaseViewModel

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val viewModel: HeartDiseaseViewModel = viewModel()

    NavHost(navController = navController, startDestination = "homeScreen"){

        composable(route = "homeScreen"){
            HomeScreen(navController, viewModel)
        }
        composable(route = "resultScreen"){
            ResultScreen(viewModel)
        }
    }
}