package com.jetbrains.weatherapp.weather

import kotlin.test.Test
import kotlin.test.assertEquals

class CelsiusToFahrenheitTest {
    @Test
    fun testZero() {
        assertEquals(
            actual = celsiusToFahrenheit(0.0),
            expected = 32.0,
            absoluteTolerance = 0.001,
            message = "0'C should be 32'F",
        )
    }

    @Test
    fun testHundred() {
        assertEquals(
            actual = celsiusToFahrenheit(100.0),
            expected = 212.0,
            absoluteTolerance = 0.001,
            message = "100'C should be 212'F"
        )
    }

    @Test
    fun testMinus(){
        assertEquals(
            actual = celsiusToFahrenheit(-100.0),
            expected = -148.0,
            absoluteTolerance = 0.001,
            message = "-100'C should be -148'F"
        )
    }
}