package com.example.heartdiseasedetetectionapp.View.HomeScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartdiseasedetetectionapp.R

@Preview(showBackground = true)
@Composable
fun CardHeading(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(170.dp)
        .background(Color.Transparent),
        colors = CardDefaults.cardColors(colorResource(id = R.color.secondary))){
        Box(modifier = Modifier.fillMaxSize().padding(10.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(
                    "Heart Disease",
                    fontSize = 35.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Detection",
                    fontSize = 35.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.offset(y = -10.dp)
                )
                Text("A machine learning model that can predict your heart disease with 96% accuracy",
                    fontSize = 15.sp, color = Color.White, modifier = Modifier.offset(y=-12.dp), textAlign = TextAlign.Left)
            }
        }
    }
}