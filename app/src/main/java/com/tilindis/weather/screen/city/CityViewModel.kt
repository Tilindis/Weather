package com.tilindis.weather.screen.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilindis.weather.utils.domain.CityViewData
import com.tilindis.weather.utils.other.citiesData
import com.tilindis.weather.utils.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
) : ViewModel() {
    private val _state: MutableLiveData<CityState> = MutableLiveData(CityState.empty())
    val state: LiveData<CityState> = _state

    init {
        viewModelScope.launch {
            getCitiesData()
        }
    }

    fun updateCity(cityName: String) {
        updateState {
            copy(
                cities = updateCityOnScreen(cityName, cities),
                citiesOffline = updateCityOnScreen(cityName, citiesOffline)
            )
        }
    }

    fun loadCities(){
        viewModelScope.launch {
            weatherUseCase.getCitiesWeather(state.value?.citiesOffline)
        }
    }

    private fun updateCityOnScreen(cityName: String, cities: List<CityViewData>) =
        cities.map { city ->
            if (city.name == cityName) {
                city.copy(onScreen = !city.onScreen)
            } else {
                city
            }
        }

    private suspend fun getCitiesData() {
        weatherUseCase.weatherFlow.collect {
            val cities = it.map { city -> city.toCitiesViewData() }
            for (item in cities) {
                updateState {
                    copy(citiesOffline = citiesOffline.map { city ->
                        if (city.name == item.name) {
                            city.copy(onScreen = item.onScreen)
                        } else {
                            city
                        }
                    })
                }
            }
            updateState {
                copy(cities = cities)
            }
        }
    }

    private fun updateState(update: CityState.() -> CityState) {
        _state.value = state.value!!.update()
    }
}
