package com.example.heartdiseasedetetectionapp.View.LoginScreen.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heartdiseasedetetectionapp.R
import com.example.heartdiseasedetetectionapp.View.LoginScreen.Components.CustomTextField
import com.example.heartdiseasedetetectionapp.View.LoginScreen.Components.TextHeading

@Preview(showBackground = true)
@Composable
fun LoginScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        TextHeading(text = "Welcome to", fontSize = 32, color = Color.Black, fontWeight = FontWeight.Medium)
        TextHeading(text = "Cardiac Compass", fontSize = 40, color = colorResource(id = R.color.secondary), fontWeight = FontWeight.Bold)

        Image(painter = painterResource(id = R.drawable.heartlogin), contentDescription = "")
            //modifier = Modifier.height(800.dp).width(800.dp))
        //Spacer(modifier = Modifier.height(100.dp))
        TextHeading(text = "Name", fontSize = 22, color = Color.Black, fontWeight = FontWeight.Medium)
        CustomTextField("Enter your name", Icons.Filled.Person)
        Spacer(modifier = Modifier.height(20.dp))
        TextHeading(text = "Date of Birth", fontSize = 22, color = Color.Black, fontWeight = FontWeight.Medium)
        CustomTextField("Enter your dob", Icons.Filled.DateRange)
    }
}