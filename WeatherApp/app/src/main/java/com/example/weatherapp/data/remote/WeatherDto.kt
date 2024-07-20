package com.example.weatherapp.data.remote

import com.squareup.moshi.Json

// is a higher-level DTO that encapsulates WeatherDataDto

data class WeatherDto(

    @field:Json(name = "hourly")
    val weatherData: WeatherDataDto
)

//WeatherDto includes WeatherDataDto as a field, meaning WeatherDto
// acts as a container for the detailed weather data provided by
// WeatherDataDto