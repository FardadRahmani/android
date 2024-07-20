package com.example.weatherapp.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weatherapp.data.remote.WeatherDataDto
import com.example.weatherapp.data.remote.WeatherDto
import com.example.weatherapp.domain.weather.WeatherData
import com.example.weatherapp.domain.weather.WeatherInfo
import com.example.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter



private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)


//For mapping dto to our domain level objects
//map weatherDataDto obj to weatherDataMap(in WeatherInfo.kt: weatherDataPerDay: Map<Int, List<WeatherData>>)
@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>>{
    //transform weatherDataDto to Map:
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        //map to weatherData obj:
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                windSpeed = windSpeed,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
                //now we have mapped our timeValues to
                //weatherData Objects and have list of WeatherData
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map {
            it.data
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDto.toWeatherInfo(): WeatherInfo{
    //create weatherDataPerDay/map
    val weatherDataMap = weatherData.toWeatherDataMap()
    //calculate currentWeatherData
    val now = LocalDateTime.now()
    //weatherDataMap contains it at index 0, which is current day
    val currentWeatherData = weatherDataMap[0]?.find {
        //here we need to find current hour of selected day:
        val hour = if (now.minute<30) now.hour else now.hour +1
        it.time.hour == hour
    }
    return WeatherInfo(

        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData
    )
}