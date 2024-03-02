package com.example.heartdiseasedetetectionapp.View.ResultScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartdiseasedetetectionapp.R

@Composable
fun ResultCard(result: Int){
    val r: String = when(result){
        0 -> "The ML model's output indicates no detectable disease"
        1 -> "The ML model's indicates a potential disease"
        else -> {""}
    }
    Card(
        modifier = Modifier
            .height(300.dp)
            .width(300.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.secondary)),
        elevation = CardDefaults.cardElevation(10.dp)
    ){
        Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {
            Text(r, fontSize = 32.sp, color = Color.White, textAlign = TextAlign.Center, fontWeight = FontWeight.Medium)
        }
    }
}