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
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDropDownMenu(items: List<String>) {
    var isExpanded by remember { mutableStateOf(false) }
    val options: List<String> = items
    var category by remember{ mutableStateOf(options[0])}

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(40.dp))
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.Transparent, shape = RoundedCornerShape(10.dp))
    ){
        ExposedDropdownMenuBox(expanded = isExpanded,
            onExpandedChange = {isExpanded = !isExpanded}) {
            TextField(value = category, onValueChange = {},
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxSize()
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp)),
                textStyle = TextStyle(fontSize = 18.sp,
                    fontWeight = FontWeight.Medium),
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                readOnly = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFD2E0FB),
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false}) {
                options.forEach{ label->
                    DropdownMenuItem(text = {Text(label, fontSize = 18.sp, fontWeight = FontWeight.Medium)}, onClick = {
                        category = label
                        isExpanded = false
                    })
                }
            }
        }
    }
}