package com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartdiseasedetetectionapp.R

@Composable
fun OnBoardingPage(data: Pages, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.spacedBy((-70.dp))
    ){
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = data.image),
                contentScale = ContentScale.Inside,
                contentDescription = "On boarding image")
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
            colors = CardDefaults.cardColors(Color.Black)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp)
            ){
                Text(text = data.title, fontSize = 30.sp, textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = data.description, fontSize = 18.sp, textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium, color = Color.White, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Display1(){
    OnBoardingPage(data = pages[1])
}

@Preview(showBackground = true)
@Composable
fun Display2(){
    OnBoardingPage(data = pages[0])
}

@Preview(showBackground = true)
@Composable
fun Display3(){
    OnBoardingPage(data = pages[2])
}