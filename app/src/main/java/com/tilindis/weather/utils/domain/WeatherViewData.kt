package com.tilindis.weather.utils.domain

data class WeatherViewData(
    val timezone: String,
    val latitude: String,
    val longitude: String,
    val temperature: String,
    val windSpeed: String,
    val windDirection: String,
    val weatherCode: String,
    val lastUpdateTime: String,
    val lastUpdateDate: String
) {
    companion object {
        private val EMPTY =
            WeatherViewData("", "", "", "", "", "", "", "", "")

        fun empty() = EMPTY
    }
}
