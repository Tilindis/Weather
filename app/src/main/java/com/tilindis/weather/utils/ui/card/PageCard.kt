package com.tilindis.weather.utils.ui.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tilindis.weather.utils.domain.HourlyViewData
import com.tilindis.weather.utils.domain.WeatherViewData
import androidx.compose.foundation.lazy.items

@Composable
fun PageCard(weatherData: WeatherViewData, hourlyData: List<HourlyViewData>) {
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
        Text(text = hourlyData.size.toString() + " - hourly data" )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(hourlyData) { item ->
                HourCard(
                    time = item.time,
                    temperature = item.temperature2m,
                    windDirection = item.winddirection10m
                )
            }
        }

//        LazyRow(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            contentPadding = PaddingValues(horizontal = 16.dp)
//        ) {
//            items(hourlyData) { item ->
//                Text(text = item.time)
//            }
//        }
    }
}

