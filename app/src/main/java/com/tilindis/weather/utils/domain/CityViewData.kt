package com.tilindis.weather.utils.domain

data class CityViewData(
    val name: String = "",
    val longitude: String = "",
    val latitude: String = "",
    val onScreen: Boolean
){
    companion object {
        private val EMPTY = CityViewData("", "", "", false)
        fun empty() = EMPTY
    }
}
