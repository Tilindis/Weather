package com.tilindis.weather.utils.usecase

import com.tilindis.weather.utils.repository.WeatherRepository

class WeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    suspend fun loadWeather() = weatherRepository.loadWeather()

    val weatherFlow = weatherRepository.weatherFlow
}
