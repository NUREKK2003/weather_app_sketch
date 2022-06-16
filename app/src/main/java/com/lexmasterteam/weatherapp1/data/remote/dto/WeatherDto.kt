package com.lexmasterteam.weatherapp1.data.remote.dto

import com.lexmasterteam.weatherapp1.domain.model.WeatherItem

data class WeatherDto(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

// mapowanie na Weather

fun WeatherDto.toWeatherItem(): WeatherItem{
    return WeatherItem(
        base = base,
        clouds = clouds,
        cod = cod,
        coord = coord,
        dt = dt,
        id = id,
        main = main,
        name = name,
        sys = sys,
        visibility = visibility,
        weather = weather,
        wind = wind
    )
}