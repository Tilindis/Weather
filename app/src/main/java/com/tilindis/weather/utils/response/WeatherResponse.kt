package com.tilindis.weather.utils.response

import com.squareup.moshi.Json
import com.tilindis.weather.utils.domain.CurrentWeatherViewData
import com.tilindis.weather.utils.domain.HourlyViewData
import com.tilindis.weather.utils.domain.WeatherViewData

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

    fun toWeatherViewData(): WeatherViewData {
        return WeatherViewData(
            timezone = timezone ?: "",
            latitude = latitude ?: "",
            longitude = longitude ?: "",
            currentWeather = currentWeather?.toCurrentWeatherViewData()
                ?: CurrentWeatherViewData.empty(),
            hourly = hourly?.toHourlyViewData() ?: HourlyViewData.empty()
        )
    }
}
