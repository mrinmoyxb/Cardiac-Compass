package com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components.OnBoardingPage
import com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components.Pages
import com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components.pages



@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun OnBoardingScreen(){
    val pagerState = rememberPagerState(pageCount = {3})

    Column(modifier= Modifier.fillMaxSize()){
        HorizontalPager(state = pagerState) {index->
            OnBoardingPage(data = pages[index])
        }
    }
}
