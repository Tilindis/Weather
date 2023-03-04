package com.tilindis.weather.utils.domain

data class WeatherViewData(
    val timezone: String,
    val latitude: String,
    val longitude: String,
    val temperature: String,
    val windspeed: String,
    val winddirection: String,
    val weathercode: String,
    val time: String
//    val hourly: HourlyViewData
) {
    companion object {
        private val EMPTY =
            WeatherViewData("", "", "", "", "", "", "", "")

        fun empty() = EMPTY
    }
}
