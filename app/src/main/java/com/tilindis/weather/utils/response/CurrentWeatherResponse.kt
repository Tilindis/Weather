package com.tilindis.weather.utils.response

import com.squareup.moshi.Json
import com.tilindis.weather.utils.domain.CurrentWeatherViewData

data class CurrentWeatherResponse(
    @field:Json(name = "temperature")
    val temperature: String? = null,

    @field:Json(name = "windspeed")
    val windspeed: String? = null,

    @field:Json(name = "winddirection")
    val winddirection: String? = null,

    @field:Json(name = "weathercode")
    val weathercode: String? = null,

    @field:Json(name = "time")
    val time: String? = null,
){
    companion object {
        private val EMPTY = CurrentWeatherResponse()
        fun empty() = EMPTY
    }

    fun toCurrentWeatherViewData(): CurrentWeatherViewData {
        return CurrentWeatherViewData(
            temperature = temperature ?: "",
            windspeed = windspeed ?: "",
            winddirection = winddirection ?: "",
            weathercode = weathercode ?: "",
            time = time ?: ""
        )
    }
}
