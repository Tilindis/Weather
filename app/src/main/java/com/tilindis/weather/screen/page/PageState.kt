package com.tilindis.weather.screen.page

import com.tilindis.weather.utils.domain.HourlyViewData
import com.tilindis.weather.utils.domain.WeatherViewData

data class PageState(
    val isAutoUpdateOn: Boolean,
    val isAutoUpdated: Boolean,
    val isFahrenheitOn: Boolean,
    val weatherData: List<WeatherViewData> = emptyList(),
    val hourlyData: List<HourlyViewData> = emptyList()
) {
    companion object {
        private val EMPTY = PageState(
            isAutoUpdateOn = false,
            isAutoUpdated = false,
            isFahrenheitOn = false,
            weatherData = emptyList(),
            hourlyData = emptyList()
        )

        fun empty() = EMPTY
    }
}
