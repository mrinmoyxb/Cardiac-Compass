package com.example.heartdiseasedetetectionapp.View.HomeScreen.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomLabel(heading: String, fontSize: Int){
    Text(heading, fontSize = fontSize.sp, color = Color.Black,
        fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 5.dp, top = 5.dp, bottom = 5.dp))
}