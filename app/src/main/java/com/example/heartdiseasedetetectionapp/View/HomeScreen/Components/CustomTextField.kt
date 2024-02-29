package com.example.heartdiseasedetetectionapp.View.HomeScreen.Components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartdiseasedetetectionapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(placeholder: String){
    var value by remember{mutableStateOf("")}

    TextField(value = value, onValueChange = {value=it},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        ),
        singleLine = true,
        maxLines = 1,
        placeholder = {Text(placeholder, fontSize = 15.sp)},
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .border(
                width = 2.dp, color = if (value == "") Color.Black else colorResource(
                    id = R.color.border
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .shadow(10.dp, shape = RoundedCornerShape(10.dp))
        )

}