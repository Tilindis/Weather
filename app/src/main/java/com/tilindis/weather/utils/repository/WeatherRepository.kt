package com.tilindis.weather.utils.repository

import com.tilindis.weather.utils.api.WeatherService
import com.tilindis.weather.utils.dao.WeatherDao
import com.tilindis.weather.utils.entity.HourlyEntity
import com.tilindis.weather.utils.entity.WeatherEntity
import com.tilindis.weather.utils.other.citiesData
import kotlinx.coroutines.flow.Flow

class WeatherRepository(
    private val weatherService: WeatherService,
    private val weatherDao: WeatherDao,
) {
    val weatherFlow: Flow<List<WeatherEntity>> = weatherDao.weatherFlow()

    val weatherHourlyFlow: Flow<List<HourlyEntity>> = weatherDao.weatherHourlyFlow()

    private val city = citiesData()[4]

    suspend fun loadWeather() =
        runCatching { weatherService.getWeather(lat = city.latitude, long = city.longitude) }.map {
            it.body()?.copy(timezone = city.name)
        }.onSuccess {
            weatherDao.deleteHourlyCityById(it?.toWeatherEntity()?.timezone ?: "")
            weatherDao.insertWeather(it?.toWeatherEntity() ?: WeatherEntity.empty())
            weatherDao.insertHourlyWeather(it?.toHourlyList() ?: listOf())
        }
}
