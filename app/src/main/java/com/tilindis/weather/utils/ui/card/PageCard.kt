package com.tilindis.weather.utils.ui.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tilindis.weather.R
import com.tilindis.weather.utils.calculation.TemperatureCalculation
import com.tilindis.weather.utils.domain.HourlyViewData
import com.tilindis.weather.utils.domain.WeatherViewData
import com.tilindis.weather.utils.format.DateFormatter
import kotlin.math.roundToInt

@Composable
fun PageCard(weatherData: WeatherViewData, weeklyData: List<HourlyViewData>, hourlyData: List<HourlyViewData>) {
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
            temperature = weatherData.temperature.toDouble().roundToInt().toString(),
            windDirection = weatherData.windDirection
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Last update time: " + weatherData.lastUpdateTime)
        Text(text = "Last update Date: " + weatherData.lastUpdateDate)

        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(4.dp),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = stringResource(R.string.weather_card_hourly_forecast_text),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(hourlyData) { item ->
                        HourCard(
                            time = DateFormatter().getOnlyHour(item.time),
                            temperature = item.temperature2m,
                            windDirection = item.winddirection10m
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        val calculatedWeeklyDate = TemperatureCalculation().calculateAverageWeekTemperature(weeklyData)

        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(4.dp),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = stringResource(R.string.weather_card_7_day_forecast_text),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(calculatedWeeklyDate) { item ->
                        DayCard(
                            day = item.dayName,
                            dayTemperature = item.dayAverageTemperature.toString(),
                            nightTemperature = item.nightAverageTemperature.toString()
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}
