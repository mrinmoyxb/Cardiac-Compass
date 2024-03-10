package com.example.heartdiseasedetetectionapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.heartdiseasedetetectionapp.Navigation.MainScreen
import com.example.heartdiseasedetetectionapp.ui.theme.HeartDiseaseDetetectionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeartDiseaseDetetectionAppTheme {
                MainScreen()
            }
        }
    }
}
