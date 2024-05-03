package com.jetbrains.weatherapp.cache

import platform.Foundation.NSHomeDirectory

actual fun pathToCountryCache(): String = "${NSHomeDirectory()}/country_cache.json"