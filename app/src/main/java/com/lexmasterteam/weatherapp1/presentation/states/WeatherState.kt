package com.lexmasterteam.weatherapp1.presentation.states

import com.lexmasterteam.weatherapp1.domain.model.WeatherItem

data class WeatherState(
    val isLoading:Boolean = false,
    val weatherInfo: WeatherItem? = null,
    val error: String = ""
)
