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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.tilindis.weather.R
import com.tilindis.weather.utils.ui.bar.BottomBar
import com.tilindis.weather.utils.ui.card.PageCard

@Composable
fun PageContent(
    state: PageState,
    onCityClick: () -> Unit,
    onLocaleClick: () -> Unit,
    onRefresh: () -> Unit
) {
    val pagerState = rememberPagerState()

    SwipeRefresh(
        state = rememberSwipeRefreshState(state.isLoading),
        onRefresh = onRefresh,
        indicator = { indicatorState, trigger ->
            CustomIndicator(state = indicatorState, trigger = trigger)
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            WeatherPage(
                state = state,
                pagerState = pagerState
            )
            BottomBar(
                pagerState = pagerState,
                rightIconResource = R.drawable.bottom_bar_list,
                leftIconResource = R.drawable.bottom_bar_settings,
                onLeftButtonClick = onLocaleClick,
                onRightButtonClick = onCityClick
            )
            Spacer(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.primaryVariant))
        }
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
        PageCard(
            weatherData = state.weatherData[page],
            weeklyData = weeklyData,
            hourlyData = hourlyData
        )
    }
}

@Composable
private fun CustomIndicator(state: SwipeRefreshState, trigger: Dp) =
    SwipeRefreshIndicator(
        state = state,
        refreshTriggerDistance = trigger,
        scale = true,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.background,
    )
