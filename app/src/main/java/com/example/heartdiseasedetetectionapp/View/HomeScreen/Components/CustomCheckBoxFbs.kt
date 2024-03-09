package com.example.heartdiseasedetetectionapp.View.HomeScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartdiseasedetetectionapp.R
import com.example.heartdiseasedetetectionapp.ViewModel.HeartDiseaseViewModel


@Composable
fun CustomCheckBoxFbs(text1: String = "Yes", text2: String = "No", viewModel: HeartDiseaseViewModel){

    var buttonStateYes by remember{mutableStateOf(false)}
    var buttonStateNo by remember{mutableStateOf(false)}

    Card(modifier = Modifier
        .height(100.dp)
        .width(176.dp)
        .background(Color.Transparent),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column() {
                        Card(
                            modifier = Modifier
                                .width(62.dp)
                                .height(62.dp)
                                .background(Color.Transparent)
                                .border(
                                    width = 1.dp,
                                    color = if (buttonStateYes == false) Color(0xFF000000) else Color(
                                        0xFF11009E
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .clickable { buttonStateYes = !buttonStateYes
                                           if(buttonStateYes) viewModel.fbsValue.value = 1 else viewModel.fbsValue.value=-1},

                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(
                                if (buttonStateYes == false) Color(
                                    0xFFFFFFFF
                                ) else Color(0xFF11009E)
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.check_white),
                                    contentDescription = "yes",
                                    modifier = Modifier.size(40.dp),
                                    tint = if (buttonStateYes == false) Color.Transparent else Color.White
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column() {
                        Card(
                            modifier = Modifier
                                .width(62.dp)
                                .height(62.dp)
                                .background(Color.Transparent)
                                .border(
                                    width = 1.dp,
                                    color = if (buttonStateNo == false) Color(0xFF000000) else Color(
                                        0xFF11009E
                                    ),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .clickable { buttonStateNo = !buttonStateNo
                                    if(buttonStateNo) viewModel.fbsValue.value = 0 else viewModel.fbsValue.value=-1},
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(
                                if (buttonStateNo == false) Color(
                                    0xFFFFFFFF
                                ) else Color(0xFF11009E)
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.check_white),
                                    contentDescription = "yes",
                                    modifier = Modifier.size(40.dp),
                                    tint = if (buttonStateNo == false) Color.Transparent else Color.White
                                )
                            }
                        }
                    }

                }

                Spacer(modifier = Modifier.height(2.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text1,
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        text2,
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
