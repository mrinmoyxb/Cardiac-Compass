//package com.example.heartdiseasedetetectionapp.View.LoginScreen.Components
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.example.heartdiseasedetetectionapp.R
//
//@Composable
//fun NextButton(navController: NavHostController){
//    Card(
//        shape = CircleShape,
//        colors = CardDefaults.cardColors(colorResource(id = R.color.border1)),
//        modifier = Modifier.size(60.dp)
//            .clickable { navController.navigate("homeScreen") },
//        elevation = CardDefaults.cardElevation(10.dp)
//    ){
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Icon(
//                imageVector = Icons.Filled.ArrowForward,
//                contentDescription = "next button",
//                tint = Color.White,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(8.dp)
//            )
//        }
//    }
//}