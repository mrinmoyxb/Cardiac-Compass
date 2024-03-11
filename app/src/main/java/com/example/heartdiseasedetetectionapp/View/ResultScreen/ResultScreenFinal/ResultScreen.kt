package com.example.heartdiseasedetetectionapp.View.ResultScreen.ResultScreenFinal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.heartdiseasedetetectionapp.R
import com.example.heartdiseasedetetectionapp.View.ResultScreen.Components.ResultCard
import com.example.heartdiseasedetetectionapp.View.ResultScreen.Components.ServerCard
import com.example.heartdiseasedetetectionapp.ViewModel.HeartDiseaseViewModel


@Composable
fun ResultScreen(viewModel: HeartDiseaseViewModel){
    //val viewModel: HeartDiseaseViewModel = viewModel()

    val result by viewModel.responseValue.collectAsState("")
    val server by viewModel.serverCode.collectAsState("")

    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.primary))
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ResultCard(result = result)
        Spacer(modifier = Modifier.height(10.dp))
        ServerCard(server = server)
    }
}