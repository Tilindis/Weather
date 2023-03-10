package com.tilindis.weather.utils.domain

data class WeekViewData(
    val dayName: String,
    val dayAverageTemperature: Int,
    val nightAverageTemperature: Int,
) {
    companion object {
        private val EMPTY =
            WeekViewData("",0, 0)

        fun empty() = EMPTY
    }
}
