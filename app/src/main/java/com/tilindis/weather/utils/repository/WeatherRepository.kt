package com.tilindis.weather.utils.repository

import com.tilindis.weather.utils.api.WeatherService
import com.tilindis.weather.utils.dao.WeatherDao
import com.tilindis.weather.utils.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

class WeatherRepository(
    private val weatherService: WeatherService,
    private val weatherDao: WeatherDao,
) {
    val weatherFlow: Flow<WeatherEntity> = weatherDao.weatherFlow()

    suspend fun loadWeather() =
        runCatching { weatherService.getWeather() }.map {
            it.body()
        }.onSuccess {
            weatherDao.deleteHourlyCityById(it?.toWeatherEntity()?.timezone ?: "")
            weatherDao.insertWeather(it?.toWeatherEntity() ?: WeatherEntity.empty())
            weatherDao.insertHourlyWeather(it?.toHourlyList() ?: listOf())
        }
}
