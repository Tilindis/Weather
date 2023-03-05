package com.tilindis.weather.utils.response

import com.squareup.moshi.Json

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
}
