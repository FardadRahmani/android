package com.example.weatherapp.domain.weather

data class WeatherInfo(
    //maps day keyInt(day, 0 today, 1 tomorrow) to weatherData List of that day:
    val weatherDataPerDay: Map<Int, List<WeatherData>>,

    //weatherData of current hour we're in:
    val currentWeatherData: WeatherData?
)
