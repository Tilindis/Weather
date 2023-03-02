package com.tilindis.weather.screen.city

data class CityState(
    val cityId: String
){
    companion object{
        private val EMPTY = CityState(cityId = "City")

        fun empty() = EMPTY
    }
}
