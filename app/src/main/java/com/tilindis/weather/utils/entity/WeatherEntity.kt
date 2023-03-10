package com.tilindis.weather.utils.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tilindis.weather.utils.domain.WeatherViewData

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey val timezone: String,
    @ColumnInfo(name = "latitude") val latitude: String,
    @ColumnInfo(name = "longitude") val longitude: String,
    @ColumnInfo(name = "temperature") val temperature: String,
    @ColumnInfo(name = "wind_speed") val windSpeed: String,
    @ColumnInfo(name = "wind_direction") val windDirection: String,
    @ColumnInfo(name = "weather_code") val weatherCode: String,
    @ColumnInfo(name = "last_update_time") val lastUpdateTime: String,
    @ColumnInfo(name = "last_update_date") val lastUpdateDate: String,
){
    companion object {
        private val EMPTY = WeatherEntity(
            timezone = "",
            latitude = "",
            longitude = "",
            temperature = "",
            windSpeed = "",
            windDirection = "",
            weatherCode = "",
            lastUpdateTime = "",
            lastUpdateDate = ""
        )
        fun empty() = EMPTY
    }

    fun toWeatherViewData(): WeatherViewData {
        return WeatherViewData(
            timezone = timezone,
            latitude = latitude,
            longitude = longitude,
            temperature = temperature,
            windSpeed = windSpeed,
            windDirection = windDirection,
            weatherCode = weatherCode,
            lastUpdateTime = lastUpdateTime,
            lastUpdateDate = lastUpdateDate
        )
    }
}
