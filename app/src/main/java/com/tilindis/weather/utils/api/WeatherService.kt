package com.tilindis.weather.utils.api

import com.tilindis.weather.utils.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {
    @GET("forecast?latitude=54.689159&longitude=25.2798&timezone=auto&current_weather=true&hourly=temperature_2m,winddirection_10m")
    suspend fun getWeather(): Response<WeatherResponse>
}
