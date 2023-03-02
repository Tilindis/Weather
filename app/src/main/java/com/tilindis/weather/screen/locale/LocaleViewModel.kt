package com.tilindis.weather.screen.locale

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocaleViewModel @Inject constructor(

): ViewModel() {
    private val _state: MutableLiveData<LocaleState> = MutableLiveData(LocaleState.empty())
    val state: LiveData<LocaleState> = _state

    private fun updateState(update: LocaleState.() -> LocaleState){
        _state.value = state.value!!.update()
    }

    fun setAutoUpdate(newValue: Boolean){
        updateState { copy(autoUpdate = newValue) }
    }
}
