package com.tilindis.weather.screen.city

data class CityState(
    val cityId: String
){
    companion object{
        private val EMPTY = CityState(cityId = "")

        fun empty() = EMPTY
    }
}
