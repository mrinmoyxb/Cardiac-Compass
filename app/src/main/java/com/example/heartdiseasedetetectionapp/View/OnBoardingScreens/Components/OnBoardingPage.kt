package com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingPage(data: Pages, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ){
        Image(painter = painterResource(id = data.image),
            contentDescription = "on boarding image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .padding(8.dp),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
            )
        Spacer(modifier = Modifier.height(5.dp))
        OnBoardingText(data = data)
    }
}

@Composable
fun OnBoardingText(data:Pages){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextComponent(text = data.title, size = 25, fontWeight = FontWeight.SemiBold, color = Color.White)
        TextComponent(text = data.description, size = 18, fontWeight = FontWeight.Medium, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun Display(){
    OnBoardingPage(data = pages[2])
}