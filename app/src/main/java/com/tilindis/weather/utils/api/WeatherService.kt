package com.tilindis.weather.utils.api

import com.tilindis.weather.utils.response.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    // veikia
    // org @GET("forecast?latitude=54.689159&longitude=25.2798&timezone=auto&current_weather=true&hourly=temperature_2m,winddirection_10m")
    @GET("forecast?latitude={latitude}&longitude={longitude}&timezone=auto&current_weather=true&hourly=temperature_2m,winddirection_10m")
    suspend fun getWeather(
        @Path("latitude", encoded = true) latitude: String,
        @Path("longitude", encoded = true) longitude: String
    ): Response<WeatherResponse>

    // metodas su tusciais parametrais veikia
    //suspend fun getWeather(): Response<WeatherResponse>
}
