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
import com.tilindis.weather.utils.domain.HourlyViewData
import com.tilindis.weather.utils.domain.WeatherViewData
import com.tilindis.weather.utils.format.FormatDate

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
        Spacer(modifier = Modifier.height(8.dp))

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
                            time = FormatDate().getHour(item.time),
                            temperature = item.temperature2m,
                            windDirection = item.winddirection10m
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

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
                    item{DayCard(day = "Monday", dayTemperature = "16", nightTemperature = "12")}
                    item{DayCard(day = "Tuesday", dayTemperature = "12", nightTemperature = "12")}
                    item{DayCard(day = "Another", dayTemperature = "14", nightTemperature = "13")}

                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = weatherData.time + " - time")

        Spacer(modifier = Modifier.height(16.dp))

        val result = calculation(hourlyData)

        Text(text = "$result - D/N SuperCalculation") // ${result[0].dayAverageTemp} - ${result[0].nightAverageTemp}

        val dayResult = FormatDate().getDayName("2023-03-09T12:00")
        Text(text = "$dayResult - Day result")
    }
}

@Composable
private fun ComponentWrapper(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(4.dp)
            .background(Color.Magenta),
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        content
    }
}

private fun calculation(hourlyData: List<HourlyViewData>): List<AverageTemp> {
    var dayAverageTemp = 0.0
    var nightAverageTemp = 0.0

    val dayNightTemps = mutableListOf<AverageTemp>()

    for (dateTimeStr in hourlyData) {
        val hourOfDay = FormatDate().getHour(dateTimeStr.time).toInt()
        if (hourOfDay in 6..17) {
            dayAverageTemp += dateTimeStr.temperature2m.toDouble()
        } else {
            nightAverageTemp += dateTimeStr.temperature2m.toDouble()
        }

        if(hourOfDay == 23){
            val avgDayTemp = dayAverageTemp / 12
            val avgNightTemp = nightAverageTemp / 12
            dayNightTemps.add(AverageTemp(avgDayTemp, avgNightTemp))
            dayAverageTemp = 0.0
            nightAverageTemp = 0.0
        }
    }

    return dayNightTemps
}

data class AverageTemp(val dayAverageTemp: Double, val nightAverageTemp: Double)
