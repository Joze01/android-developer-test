package com.sacredvalley.util.preference.base

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.VisibleForTesting

@Suppress("SameParameterValue", "unused")
abstract class BasePreference(context: Context, preferenceKey: String) {

    private var preferences: SharedPreferences = context.getSharedPreferences(
        preferenceKey,
        Context.MODE_PRIVATE
    )

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun getString(key: String, def: String) =
        preferences.getString(key, def) ?: def

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun putString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun getBoolean(key: String, def: Boolean) =
        preferences.getBoolean(key, def)

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun putBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun getInt(key: String, def: Int) =
        preferences.getInt(key, def)

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun putInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun putLong(key: String, value: Long) {
        preferences.edit().putLong(key, value).apply()
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun getLong(key: String, def: Long) =
        preferences.getLong(key, def)

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    fun clear() = preferences.edit()
        .clear().apply()
}