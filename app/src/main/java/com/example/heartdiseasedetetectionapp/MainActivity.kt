package com.example.heartdiseasedetetectionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.heartdiseasedetetectionapp.Navigation.MainScreen
import com.example.heartdiseasedetetectionapp.View.HomeScreen.HomeScreenFinal.HomeScreen
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
