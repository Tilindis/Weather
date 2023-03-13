package com.tilindis.weather.screen.city

import com.tilindis.weather.utils.domain.CityViewData
import com.tilindis.weather.utils.other.citiesData

data class CityState(
    val cities: List<CityViewData> = emptyList(),
    val citiesOffline: List<CityViewData> = emptyList()
) {
    companion object {
        private val EMPTY = CityState(cities = emptyList(), citiesOffline = citiesData())

        fun empty() = EMPTY
    }
}
