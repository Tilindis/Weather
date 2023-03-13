package com.tilindis.weather.utils.repository

import com.tilindis.weather.utils.api.WeatherService
import com.tilindis.weather.utils.dao.WeatherDao
import com.tilindis.weather.utils.entity.HourlyEntity
import com.tilindis.weather.utils.entity.WeatherEntity
import com.tilindis.weather.utils.format.DateFormatter
import kotlinx.coroutines.flow.Flow

class WeatherRepository(
    private val weatherService: WeatherService,
    private val weatherDao: WeatherDao,
    private val dateFormatter: DateFormatter
) {
    val weatherFlow: Flow<List<WeatherEntity>> = weatherDao.weatherFlow()

    val weatherHourlyFlow: Flow<List<HourlyEntity>> = weatherDao.weatherHourlyFlow()

    suspend fun loadWeather(cityName: String, latitude: String, longitude: String) =
        runCatching { weatherService.getWeather(lat = latitude, long = longitude) }.map {
            it.body()?.copy(timezone = cityName)
        }.onSuccess {
            weatherDao.deleteHourlyCityByCityName(it?.toWeatherEntity()?.timezone ?: "")
            weatherDao.insertWeather(
                it?.toWeatherEntity()?.copy(
                    lastUpdateTime = dateFormatter.getCurrentTime(),
                    lastUpdateDate = dateFormatter.getCurrentDate()
                )
                    ?: WeatherEntity.empty()
            )
            weatherDao.insertHourlyWeather(it?.toHourlyList() ?: listOf())
        }

    suspend fun deleteFullCityData(cityName: String){
        weatherDao.deleteWeatherByCityName(cityName)
        weatherDao.deleteHourlyCityByCityName(cityName)
    }
}
