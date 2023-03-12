package com.tilindis.weather.utils.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.tilindis.weather.utils.other.Constants.DATASTORE_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStore @Inject constructor(@ApplicationContext val context: Context) {
    val getSettings: Flow<Settings> = context.dataStore.data
        .map { preferences ->
            Settings(
                preferences[AUTO_UPDATE_KEY] ?: false,
                preferences[UNIT_KEY] ?: false
            )
        }

    suspend fun setAutoUpdateValue(status: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[AUTO_UPDATE_KEY] = status
        }
    }

    suspend fun setFahrenheitOn(status: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[UNIT_KEY] = status
        }
    }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATASTORE_NAME)
        val AUTO_UPDATE_KEY = booleanPreferencesKey("key.is_auto_update_on")
        val UNIT_KEY = booleanPreferencesKey("key.is_unit_fahrenheit_on")
    }

    data class Settings(val autoUpdate: Boolean, val unit: Boolean)
}
