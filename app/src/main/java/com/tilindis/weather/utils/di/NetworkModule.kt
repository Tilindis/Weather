package com.tilindis.weather.utils.di

import com.tilindis.weather.utils.other.Constants
import com.tilindis.weather.utils.api.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideWeatherApiService(@Named(Constants.RETROFIT_WEATHER_NAME) retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)

    @Singleton
    @Provides
    @Named(Constants.RETROFIT_WEATHER_NAME)
    fun provideRetrofitWeather(okHttpClient: OkHttpClient): Retrofit =
        createRetrofitBuilder(okHttpClient, Constants.WEATHER_URL)

    private fun createRetrofitBuilder(okHttpClient: OkHttpClient, url: String) = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(url)
        .client(okHttpClient)
        .build()
}
