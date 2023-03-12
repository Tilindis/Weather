package com.tilindis.weather.screen.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
            //weatherUseCase.loadWeather()
        }
    }

    fun updateCity(cityName: String) {
        updateState {
            copy(cities = cities.map { city ->
                if (city.name == cityName) {
                    city.copy(onScreen = !city.onScreen)
                } else {
                    city
                }
            })
        }
    }

    private suspend fun getCitiesData() {
        weatherUseCase.weatherFlow.collect {
            updateState { copy(cities = it.map { city -> city.toCitiesViewData() }) }
        }

    }

    private fun updateState(update: CityState.() -> CityState) {
        _state.value = state.value!!.update()
    }
}
