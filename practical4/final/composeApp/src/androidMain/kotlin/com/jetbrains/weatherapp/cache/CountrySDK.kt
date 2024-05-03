package com.jetbrains.weatherapp.cache

import android.content.Context
import androidx.startup.Initializer

lateinit var filePath: String

class PathInitializer : Initializer<String> {
    override fun create(context: Context): String {
        filePath = "${context.filesDir.path}/country_cache.json"
        return filePath
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

}

actual fun pathToCountryCache(): String = filePath