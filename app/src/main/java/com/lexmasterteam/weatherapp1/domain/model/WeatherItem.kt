package com.lexmasterteam.weatherapp1.domain.model

import com.lexmasterteam.weatherapp1.data.remote.dto.*
import com.lexmasterteam.weatherapp1.data.remote.dto.Weather

data class WeatherItem(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)
