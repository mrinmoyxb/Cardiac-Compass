package com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(text: String, size: Int, fontWeight: FontWeight, color: Color){
    Text(text,
        fontSize = size.sp,
        fontWeight = fontWeight,
        color = color,
        textAlign = TextAlign.Left
        )
}