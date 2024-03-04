package com.example.heartdiseasedetetectionapp.View.LoginScreen.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heartdiseasedetetectionapp.View.LoginScreen.Components.CustomTextField

@Preview(showBackground = true)
@Composable
fun LoginScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        CustomTextField("Enter your name", Icons.Filled.Person)
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField("Enter your dob", Icons.Filled.DateRange)
    }
}