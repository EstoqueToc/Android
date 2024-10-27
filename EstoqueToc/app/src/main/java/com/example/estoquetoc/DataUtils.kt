package com.example.estoquetoc

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.estoquetoc.BuildConfig.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

val Context.dataStore by preferencesDataStore(name = "api_preferences")
val tokenPreferencesKey = stringPreferencesKey(name = "api_token")

suspend fun salvarToken(context: Context, token: String) {
    context.dataStore.edit { preferences ->
        preferences[tokenPreferencesKey] = token
    }
}

fun obterToken(context: Context): Flow<String> {
    return context.dataStore.data.map { preferences ->
        preferences[tokenPreferencesKey] ?: "VAZIO"
    }
}