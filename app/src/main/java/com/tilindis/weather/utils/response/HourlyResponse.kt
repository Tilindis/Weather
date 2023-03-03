package com.tilindis.weather.utils.response

import com.squareup.moshi.Json
import com.tilindis.weather.utils.domain.HourlyViewData

data class HourlyResponse(
    @field:Json(name = "time")
    val time: List<String>? = listOf(),

    @field:Json(name = "temperature_2m")
    val temperature2m: List<String>? = listOf(),

    @field:Json(name = "winddirection_10m")
    val winddirection10m: List<String>? = listOf(),
){
    companion object {
        private val EMPTY = HourlyResponse()
        fun empty() = EMPTY
    }

    fun toHourlyViewData(): HourlyViewData {
        return HourlyViewData(
            time = time ?: listOf(),
            temperature2m = temperature2m ?: listOf(),
            winddirection10m = winddirection10m ?: listOf()
        )
    }
}
