package com.example.heartdiseasedetetectionapp.View.HomeScreen.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartdiseasedetetectionapp.ViewModel.HeartDiseaseViewModel


@Composable
fun SexCardMale(label: String, image: Painter, viewModel: HeartDiseaseViewModel){

    var cardState by remember{mutableStateOf(false)}
    var iconState by remember{mutableStateOf(false)}
    var textState by remember{ mutableStateOf(false)}

    Card(modifier = Modifier
        .height(176.dp)
        .width(176.dp)
        .clickable { cardState =!cardState
            iconState =!iconState
            textState =!textState
            if(cardState) viewModel.sex.value = 1 else viewModel.sex.value =-1
                   },
        colors = CardDefaults.cardColors(if(!cardState) Color(0xFFFFFFFF) else Color(0xFF11009E)),
        elevation = CardDefaults.cardElevation(10.dp)
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(13.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = image, contentDescription = "male",
                    modifier = Modifier.size(90.dp),
                    tint = if(iconState==false) Color.Black else Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(label, fontSize = 20.sp, color = if(textState==false) Color.Black else Color.White)
            }
        }
    }
}