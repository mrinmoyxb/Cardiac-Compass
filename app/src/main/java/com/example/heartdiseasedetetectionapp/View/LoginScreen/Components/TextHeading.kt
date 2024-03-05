package com.example.heartdiseasedetetectionapp.View.LoginScreen.Components

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.heartdiseasedetetectionapp.ui.theme.montserrat

@Composable
fun TextHeading(
    text: String,
    fontSize: Int,
    color: Color,
    fontWeight: FontWeight,
    style: TextStyle = TextStyle(),
    modifier: Modifier = Modifier
    ){
    Text(text, fontSize = fontSize.sp, color = color, fontWeight = fontWeight, fontFamily = montserrat, style = style, modifier = modifier)
}