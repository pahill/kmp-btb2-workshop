package com.jetbrains.weatherapp.cache

import net.harawata.appdirs.AppDirsFactory

actual fun pathToCountryCache(): String {
    val appDir = AppDirsFactory.getInstance().getUserDataDir("weatherapp", "1.0.0", "workshop")
    return "$appDir/country_cache.json"
}