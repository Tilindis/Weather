package com.tilindis.weather.utils.domain

data class WeatherViewData(
    val timezone: String,
    val latitude: String,
    val longitude: String,
    val currentWeather: CurrentWeatherViewData,
    val hourly: HourlyViewData
) {
    companion object {
        private val EMPTY =
            WeatherViewData("", "", "", CurrentWeatherViewData.empty(), HourlyViewData.empty())

        fun empty() = EMPTY
    }
}
