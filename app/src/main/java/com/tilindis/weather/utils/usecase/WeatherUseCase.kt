package com.tilindis.weather.utils.usecase

import com.tilindis.weather.utils.domain.CityViewData
import com.tilindis.weather.utils.repository.WeatherRepository

class WeatherUseCase(
    private val weatherRepository: WeatherRepository
) {
    //suspend fun loadWeather() = weatherRepository.loadWeather()

    val weatherFlow = weatherRepository.weatherFlow

    val weatherHourlyFlow = weatherRepository.weatherHourlyFlow

    suspend fun getCitiesWeather(cities: List<CityViewData>?) {
        if (cities != null) {
            for (city in cities) {
                if (city.onScreen) {
                    weatherRepository.loadWeather(city.name, city.latitude, city.longitude)
                } else {
                    weatherRepository.deleteFullCityData(city.name)
                }
            }
        }
    }
}
