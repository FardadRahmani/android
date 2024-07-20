package com.example.weatherapp.di

import android.app.Application
import com.example.weatherapp.data.remote.WeatherApi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

//di= Dependency Injection
//Here we tell Dagger Hilt: This is how we can create Retrofit, LocationTracker etc

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Retrofit Interface:
    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi{
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(app)
    }

}