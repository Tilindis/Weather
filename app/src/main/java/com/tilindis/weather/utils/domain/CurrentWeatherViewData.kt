package com.tilindis.weather.utils.domain

data class CurrentWeatherViewData(
    val temperature: String,
    val windspeed: String,
    val winddirection: String,
    val weathercode: String,
    val time: String
){
    companion object {
        private val EMPTY = CurrentWeatherViewData("", "", "", "", "")
        fun empty() = EMPTY
    }
}
