package com.jetbrains.weatherapp.time

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration.Companion.seconds

class TimeApi {
    private val clockTime = flow {
        while(true) {
            emit(formatTime(Clock.System.now()))
            delay(1.seconds)
        }
    }

    val actualTime = clockTime.stateIn(GlobalScope, SharingStarted.Eagerly, "N/A")

    private fun formatTime(time: Instant): String {
        val localDateTime = time.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localDateTime.hour}:${localDateTime.minute}:${localDateTime.second}"
    }

}