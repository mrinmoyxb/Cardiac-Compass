package com.example.heartdiseasedetetectionapp.View.HomeScreen.HomeScreenFinal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heartdiseasedetetectionapp.R
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CardHeading
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomLabel
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.CustomTextField
import com.example.heartdiseasedetetectionapp.View.HomeScreen.Components.SexCard

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.primary))
        .padding(10.dp)){

        Spacer(modifier = Modifier.height(30.dp))
        CardHeading()
        Spacer(modifier = Modifier.height(15.dp))

        CustomLabel(heading = "Gender", 22)

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround)
        {
            SexCard("Male", painterResource(id = R.drawable.male))
            Spacer(modifier = Modifier.width(4.dp))
            SexCard("Female", painterResource(id = R.drawable.female))
        }
        Spacer(modifier = Modifier.height(12.dp))

        CustomLabel(heading = "Heart Rate", 22)
        CustomTextField("Enter heart rate")

    }
}
