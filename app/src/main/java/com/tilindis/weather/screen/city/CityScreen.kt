package com.tilindis.weather.screen.city

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CityScreen(cityViewModel: CityViewModel = hiltViewModel()) {
    val state: CityState by cityViewModel.state.observeAsState(CityState.empty())

    CityContent(state)
}
