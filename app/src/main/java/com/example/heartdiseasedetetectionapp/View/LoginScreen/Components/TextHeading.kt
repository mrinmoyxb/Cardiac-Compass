package com.example.heartdiseasedetetectionapp.View.LoginScreen.Components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextHeading(
    text: String,
    fontSize: Int,
    color: Color,
    fontWeight: FontWeight
    ){
    Text(text, fontSize = fontSize.sp, color = color, fontWeight = fontWeight)
}