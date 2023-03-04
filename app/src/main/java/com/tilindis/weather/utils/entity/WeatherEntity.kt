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
    @ColumnInfo(name = "windspeed") val windspeed: String,
    @ColumnInfo(name = "winddirection") val winddirection: String,
    @ColumnInfo(name = "weathercode") val weathercode: String,
    @ColumnInfo(name = "time") val time: String,
){
    companion object {
        private val EMPTY = WeatherEntity(
            timezone = "",
            latitude = "",
            longitude = "",
            temperature = "",
            windspeed = "",
            winddirection = "",
            weathercode = "",
            time = ""
        )
        fun empty() = EMPTY
    }

    fun toWeatherViewData(): WeatherViewData {
        return WeatherViewData(
            timezone = timezone,
            latitude = latitude,
            longitude = longitude,
            temperature = temperature,
            windspeed = windspeed,
            winddirection = winddirection,
            weathercode = weathercode,
            time = time
        )
    }
}
