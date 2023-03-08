package com.tilindis.weather.utils.ui.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tilindis.weather.utils.domain.WeatherViewData

@Composable
fun PageCard(weatherData: WeatherViewData) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = weatherData.timezone)
        HourCard(
            time = null,
            temperature = weatherData.temperature,
            windDirection = weatherData.winddirection
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item { Text(text = weatherData.timezone) }
            item { Text(text = weatherData.latitude) }
            item { Text(text = weatherData.longitude) }
            item { Text(text = weatherData.temperature) }
            item { Text(text = weatherData.time) }
            item { Text(text = weatherData.windspeed) }
        }
    }
}

