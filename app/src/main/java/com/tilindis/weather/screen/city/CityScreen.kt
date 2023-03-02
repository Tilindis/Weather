package com.tilindis.weather.screen.city

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CityScreen(
    cityViewModel: CityViewModel = hiltViewModel(),
    navController: NavController
) {
    val state: CityState by cityViewModel.state.observeAsState(CityState.empty())

    CityContent(state)
}
