package com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ScreenButton(text: String, onClick: ()-> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.White),
    ) {
        Text(text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
            )
    }
}