package com.jetbrains.weatherapp.cache

import com.jetbrains.weatherapp.country.Country
import com.jetbrains.weatherapp.network.CountryApi
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf

class CountrySDK {
    private val cache: KStore<List<Country>> = storeOf(filePath = pathToCountryCache())
    private val api: CountryApi = CountryApi()

    @Throws(Exception::class)
    suspend fun getAllCountries(): List<Country> {
        return cache.get()
            ?: api.getAllCountries().also {
                cache.set(it)
            }
    }
}

expect fun pathToCountryCache(): String