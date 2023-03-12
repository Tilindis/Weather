package com.tilindis.weather.screen.city

import com.tilindis.weather.utils.domain.CityViewData

data class CityState(
    val cities: List<CityViewData> = emptyList()
){
    companion object{
        private val EMPTY = CityState(cities = emptyList())

        fun empty() = EMPTY
    }
}
