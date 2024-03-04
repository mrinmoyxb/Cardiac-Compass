package com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components.OnBoardingPage
import com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components.Pages
import com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components.ScreenButton
import com.example.heartdiseasedetetectionapp.View.OnBoardingScreens.Components.pages
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun OnBoardingScreen() {
        val pagerState = rememberPagerState(pageCount = { 3 })

        Column(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(state = pagerState) { index ->
                OnBoardingPage(data = pages[index], pagerState = pagerState)
            }

        }
}

