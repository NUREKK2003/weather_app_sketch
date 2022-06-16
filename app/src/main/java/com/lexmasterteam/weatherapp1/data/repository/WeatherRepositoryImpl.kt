package com.lexmasterteam.weatherapp1.data.repository

import android.util.Log
import com.lexmasterteam.weatherapp1.data.remote.WeatherApi
import com.lexmasterteam.weatherapp1.data.remote.dto.WeatherDto
import com.lexmasterteam.weatherapp1.data.remote.dto.toWeatherItem
import com.lexmasterteam.weatherapp1.domain.repository.WeatherRepository
import javax.inject.Inject // Dagger!

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository{
    override suspend fun getWeather(lat: String, lon: String, APIKEY: String): WeatherDto {
        Log.d("APIWEATHER","/data/2.5/weather?lat=$lat&lon=$lon&appid=$APIKEY")
        return api.getWeather(lat,lon,APIKEY)
    }
}