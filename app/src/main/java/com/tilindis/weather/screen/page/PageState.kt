package com.tilindis.weather.screen.page

import com.tilindis.weather.utils.domain.HourlyViewData
import com.tilindis.weather.utils.domain.WeatherViewData

data class PageState(
    val isPageOn: Boolean,
    val weatherData: List<WeatherViewData> = emptyList(),
    val hourlyData: List<HourlyViewData> = emptyList()
) {
    companion object {
        private val EMPTY = PageState(
            isPageOn = false,
            weatherData = emptyList(),
            hourlyData = emptyList()
        )

        fun empty() = EMPTY
    }
}
