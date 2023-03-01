@file:OptIn(ExperimentalPagerApi::class)

package com.tilindis.weather.screen.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*

@Composable
fun PageContent(
    state: PageState,
    onPageButtonClick: () -> Unit
) {
    val pagerState = rememberPagerState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WeatherPage(pagerState = pagerState)
        WeatherPageNavigationBar(pagerState = pagerState)
        Spacer(modifier = Modifier.fillMaxSize())
    }
}

@Composable
private fun WeatherPage(
    pagerState: PagerState,
) {
    //val coroutineScope = rememberCoroutineScope()
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.92f)
            .background(Color.Cyan),
        count = 5, //tutorialItems.count(),
        state = pagerState
    ) { page ->
        Text(text = page.toString())
    }
}

@Composable
private fun WeatherPageNavigationBar(
    pagerState: PagerState
) {
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) { Text(text = "S", modifier = Modifier.align(Alignment.Center)) }
        Box(
            modifier = Modifier
                .weight(4f)
        ) {
            HorizontalPagerIndicator(
                modifier = Modifier.align(Alignment.Center),
                pagerState = pagerState,
                activeColor = MaterialTheme.colors.primaryVariant,
                indicatorWidth = 8.dp,
                inactiveColor = Color.Green,
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) { Text(text = "C", modifier = Modifier.align(Alignment.Center)) }
    }
}
