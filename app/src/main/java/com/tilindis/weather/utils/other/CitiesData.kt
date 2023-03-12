package com.tilindis.weather.utils.other

fun citiesData() =
    listOf(
        City("Vilnius", longitude = "25.2798", latitude = "54.689159"),
        City("Kaunas", longitude = "23.9", latitude = "54.900002"),
        City("Berlin", longitude = "13.41053", latitude = "52.524368"),
        City("Dublin", longitude = "-6.24922", latitude = "53.355122"),
        City("Barcelona", longitude = "2.12804", latitude = "41.399422")
    )

data class City(
    val name: String = "",
    val longitude: String = "",
    val latitude: String = "",
)
