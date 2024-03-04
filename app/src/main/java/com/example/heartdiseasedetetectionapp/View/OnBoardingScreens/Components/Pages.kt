package com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.painterResource
import com.example.heartdiseasedetetectionapp.R

data class Pages(
    val title: String,
    val description: String,
    @DrawableRes var image: Int
)

val pages: List<Pages> = listOf(
    Pages(title = "Know Your Heart", description = "Take control of your health with our AI-powered heart disease detection tool", R.drawable.heart1),
    Pages(title = "Quick & Easy", description = "Answer a few simple questions and get personalized insights in seconds", R.drawable.heart2),
    Pages(title = "Empowerment, not Diagnosis", description = "This app is designed to inform, not diagnose. Consult your doctor for any concerns", R.drawable.heart3)
)