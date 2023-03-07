package com.tilindis.weather.screen.city

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CityContent(state: CityState) {
    Box(modifier = Modifier
        .fillMaxSize())
    {
        Text(text = state.cityId)
        // Add list for cities
    }
}
