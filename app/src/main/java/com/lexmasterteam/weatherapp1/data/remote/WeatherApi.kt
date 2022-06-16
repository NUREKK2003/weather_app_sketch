package com.lexmasterteam.weatherapp1.data.remote

import com.lexmasterteam.weatherapp1.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    // tak dodaje się wiele parametrów do linku
    @GET("/data/2.5/weather?")
    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon:String,
        @Query("appid") apikey:String) : WeatherDto
}