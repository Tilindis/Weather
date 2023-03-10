@file:OptIn(ExperimentalPagerApi::class)

package com.tilindis.weather.screen.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tilindis.weather.R
import com.tilindis.weather.utils.ui.card.PageCard

@Composable
fun PageContent(
    state: PageState,
    onCityClick: () -> Unit,
    onLocaleClick: () -> Unit
) {
    val pagerState = rememberPagerState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        WeatherPage(
            state = state,
            pagerState = pagerState
        )
        WeatherPageNavigationBar(
            pagerState = pagerState,
            onCityClick = onCityClick,
            onLocaleClick = onLocaleClick
        )
        Spacer(modifier = Modifier.fillMaxSize())
    }
}

@Composable
private fun WeatherPage(
    state: PageState,
    pagerState: PagerState
) {
    HorizontalPager(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.92f)
            .background(Color.Cyan),
        count = state.weatherData.count(),
        state = pagerState
    ) { page ->
        val weeklyData = state.hourlyData.filter { it.timezone == state.weatherData[page].timezone }
        val hourlyData = weeklyData.take(24)
        PageCard(weatherData = state.weatherData[page], weeklyData = weeklyData, hourlyData = hourlyData)
    }
}

@Composable
private fun WeatherPageNavigationBar(
    pagerState: PagerState,
    onCityClick: () -> Unit,
    onLocaleClick: () -> Unit
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
        ) {
            IconButton(onClick = onLocaleClick) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        }
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
        ) {
            IconButton(onClick = onCityClick) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        }
    }
}
