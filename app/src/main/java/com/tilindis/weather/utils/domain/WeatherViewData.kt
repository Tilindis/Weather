package com.tilindis.weather.utils.domain

data class WeatherViewData(
    val timezone: String,
    val latitude: String,
    val longitude: String
) {
    companion object {
        private val EMPTY = WeatherViewData("", "", "")
        fun empty() = EMPTY
    }
}
