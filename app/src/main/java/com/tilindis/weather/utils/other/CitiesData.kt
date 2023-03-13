package com.tilindis.weather.utils.other

import com.tilindis.weather.utils.domain.CityViewData

fun citiesData() =
    listOf(
        CityViewData("Vilnius", longitude = "25.2798", latitude = "54.689159", onScreen = false),
        CityViewData("Kaunas", longitude = "23.9", latitude = "54.900002", onScreen = false),
        CityViewData("Berlin", longitude = "13.41053", latitude = "52.524368", onScreen = false),
        CityViewData("Dublin", longitude = "-6.24922", latitude = "53.355122", onScreen = false),
        CityViewData("Barcelona", longitude = "2.12804", latitude = "41.399422", onScreen = false)
    )
