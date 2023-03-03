package com.tilindis.weather.utils.repository

import com.tilindis.weather.utils.api.WeatherService
import com.tilindis.weather.utils.domain.WeatherViewData

class WeatherRepository(
    private val retrofitApi: WeatherService
) {
    suspend fun getWeatherData(): WeatherViewData {
        val weatherResponse = retrofitApi.getWeather()

        return if (weatherResponse.isSuccessful) {
            weatherResponse.body()?.toWeatherViewData() ?: WeatherViewData.empty()
        } else {
            WeatherViewData.empty()
        }
    }
}
