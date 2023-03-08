package com.tilindis.weather.utils.api

import com.tilindis.weather.utils.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast?timezone=auto&current_weather=true&hourly=temperature_2m,winddirection_10m")
    suspend fun getWeather(
        @Query("latitude") lat: String,
        @Query("longitude") long: String
    ): Response<WeatherResponse>
}
