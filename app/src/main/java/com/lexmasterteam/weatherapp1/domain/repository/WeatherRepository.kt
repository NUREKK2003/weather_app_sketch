package com.lexmasterteam.weatherapp1.domain.repository

import com.lexmasterteam.weatherapp1.data.remote.dto.WeatherDto

// to służy do testowania programu bez używania api // fake repository
interface WeatherRepository {
    suspend fun getWeather(lat:String,lon:String,APIKEY:String): WeatherDto


}