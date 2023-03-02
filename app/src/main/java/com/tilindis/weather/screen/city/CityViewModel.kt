package com.tilindis.weather.screen.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(

): ViewModel() {
    private val _state: MutableLiveData<CityState> = MutableLiveData(CityState.empty())
    val state: LiveData<CityState> = _state

    private fun updateState(update: CityState.() -> CityState){
        _state.value = state.value!!.update()
    }

    fun setId(newId: String){
        updateState { copy(cityId = newId) }
    }
}
