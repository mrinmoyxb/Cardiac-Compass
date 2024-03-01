package com.example.heartdiseasedetetectionapp.View.HomeScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CustomDropDownMenu() {
    var isExpanded by remember { mutableStateOf(false) }
    val options: List<String> = listOf("Angina", "Atypical angina", "Non-anginal", "Asymptomatic")
    var category by remember{ mutableStateOf(options[0])}

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
    ){
        ExposedDropdownMenuBox(expanded = isExpanded,
            onExpandedChange = {isExpanded = !isExpanded}) {
            TextField(value = category, onValueChange = {},
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxSize(),
                readOnly = true,
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                )
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false}) {
                options.forEach{ label->
                    DropdownMenuItem(text = {Text(label)}, onClick = {
                        category = label
                        isExpanded = false
                    })
                }
            }
        }
    }
}