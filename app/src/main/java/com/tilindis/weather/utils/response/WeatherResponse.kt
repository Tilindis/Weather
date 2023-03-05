package com.tilindis.weather.utils.response

import com.squareup.moshi.Json
import com.tilindis.weather.utils.entity.HourlyEntity
import com.tilindis.weather.utils.entity.WeatherEntity

data class WeatherResponse(
    @field:Json(name = "timezone")
    val timezone: String? = null,

    @field:Json(name = "latitude")
    val latitude: String? = null,

    @field:Json(name = "longitude")
    val longitude: String? = null,

    @field:Json(name = "current_weather")
    val currentWeather: CurrentWeatherResponse? = CurrentWeatherResponse.empty(),

    @field:Json(name = "hourly")
    val hourly: HourlyResponse? = HourlyResponse.empty()
) {
    companion object {
        private val EMPTY = WeatherResponse()
        fun empty() = EMPTY
    }

    fun toWeatherEntity(): WeatherEntity {
        return WeatherEntity(
            timezone = timezone ?: "",
            latitude = latitude ?: "",
            longitude = longitude ?: "",
            temperature = currentWeather?.temperature ?: "",
            windspeed = currentWeather?.windspeed ?: "",
            winddirection = currentWeather?.winddirection ?: "",
            weathercode = currentWeather?.weathercode ?: "",
            time = currentWeather?.time ?: ""
        )
    }

    fun toHourlyList(): List<HourlyEntity> {
        return hourly?.time?.take(24)?.map { time ->
            HourlyEntity(
                id = null,
                timezone = timezone ?: "",
                time = time,
                temperature2m = hourly.temperature2m?.get(hourly.time.indexOf(time)) ?: "",
                winddirection10m = hourly.winddirection10m?.get(hourly.time.indexOf(time)) ?: ""
            )
        } ?: emptyList()
    }
}
